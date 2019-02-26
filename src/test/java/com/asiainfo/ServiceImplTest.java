package com.asiainfo;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceImplTest {
	private ServiceImpl serviceImpl = new ServiceImpl();
	
	@Test
	public void testMet1() {
		serviceImpl.met1();
	}

	@Test
	public void testMet2() {
		serviceImpl.met2();
	}
	
	@Test
	public void testMet3() {
		MyHandler myHandler = new MyHandler(serviceImpl);
		IService service = (IService) Proxy.newProxyInstance(serviceImpl.getClass().getClassLoader(), serviceImpl.getClass().getInterfaces(), myHandler);
		service.met3();
	}

	@Test
	public void testMet3_2() {
		MyCglibProxy myCglibProxy = new MyCglibProxy();
		ServiceImpl serviceImpl = (ServiceImpl) myCglibProxy.getProxy(ServiceImpl.class);
		serviceImpl.met3();
	}
	
	@Test
	public void testServe() {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new GreetBeforeAdvice());
		proxyFactory.setTarget(new WaiterImpl());
		proxyFactory.setInterfaces(new WaiterImpl().getClass().getInterfaces());
		proxyFactory.setOptimize(true);
		Object proxy = proxyFactory.getProxy();
		System.out.println(proxy.getClass());
		System.out.println("--------------");
		WaiterImpl waiterImpl = (WaiterImpl) proxy;
		waiterImpl.serve1("zzw");
		System.out.println("--------------");
		waiterImpl.serve2("zzw");
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Object bean = applicationContext.getBean("waiter");
		System.out.println(bean.getClass());// 可以看到引介增强使用cglib代理实现的
		System.out.println(bean.getClass().getSuperclass()); // 可以看到引介增强创建的是目标类的子类（代理类）的实例
		System.out.println(bean.getClass().getInterfaces()[0]);// 可以看到子类实现类父类并没有实现的接口
		WaiterImpl waiterImpl = (WaiterImpl) bean;
		waiterImpl.serve1("zzw");
		
		System.out.println("----------------");
		GreetSwitch myIntroductionInterceptor = (GreetSwitch) waiterImpl;
		myIntroductionInterceptor.setGreetingActive(true);
		waiterImpl.serve1("zzw");
	}
}
