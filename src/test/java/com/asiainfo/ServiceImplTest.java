package com.asiainfo;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

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
		WaiterImpl waiterImpl = (WaiterImpl) proxyFactory.getProxy();
		waiterImpl.serve1("zzw");
		System.out.println("--------------");
		waiterImpl.serve2("zzw");
	}
}
