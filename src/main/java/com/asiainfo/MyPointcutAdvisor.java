package com.asiainfo;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

/**
 * 自定义切点切面
 * 
 * @author zhangzhiwang
 * @date 2019年2月26日 下午2:27:56
 */
public class MyPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {
	@Override
	public boolean matches(Method paramMethod, Class<?> paramClass) {// 方法匹配，相当于切点中的方法匹配器，实现的是方法匹配器的matches方法
		return "getUser".equals(paramMethod.getName());// 只匹配方法名为serve1的方法
	}
}
