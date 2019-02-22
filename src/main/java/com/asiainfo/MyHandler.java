package com.asiainfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * 
 * @author zhangzhiwang
 * @date 2019年2月22日 下午12:43:01
 */
public class MyHandler implements InvocationHandler {
	private Object obj;

	public MyHandler() {
		super();
	}

	public MyHandler(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long begin = Statics.begin();
		Object returnObj = method.invoke(obj, args);
		Statics.end(begin);
		return returnObj;
	}

}
