package com.asiainfo;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib代理
 * 
 * @author zhangzhiwang
 * @date 2019年2月22日 下午1:42:25
 */
public class MyCglibProxy implements MethodInterceptor {
	
	public Object getProxy(Class clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {// 参数依次为：被代理的对象，被代理对象的方法，被代理对象方法的参数，代理对象
		long begin = Statics.begin();
		Object returnObj = proxy.invokeSuper(obj, args);// 代理对象调用被代理对象的方法（子类调用父类的方法）
		Statics.end(begin);
		return returnObj;
	}

}
