package com.asiainfo;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.stereotype.Component;

/**
 * 动态切面
 * 
 * @author zhangzhiwang
 * @date 2019年2月27日 下午2:24:13
 */
@Component
public class MyDynamicPointcut extends DynamicMethodMatcherPointcut {
	private String[] params = new String[] { "aaa", "bbb" };

//	@Override
//	public ClassFilter getClassFilter() {// 不复写getClassFilter方法会默认匹配所有类，ClassFilter为Pointcut的组成部分
//		return new ClassFilter() {
//
//			@Override
//			public boolean matches(Class<?> paramClass) {
//				System.out.println("通过ClassFilter#matches()对" + paramClass.getName() + "做静态的目标类检查");
//				return WaiterImpl.class.isAssignableFrom(paramClass);
//			}
//
//		};
//	}

//	@Override
//	public boolean matches(Method method, Class<?> claszz) {// 复写的是MethodMatcher里面用于静态匹配的matches方法，而MethodMatcher是构成Pointcut的一部分
//		System.out.println("调用MethodMatcher#matches()，对" + claszz.getName() + "的" + method.getName() + "方法进行静态检查（检查方法签名）");
//		return "serve1".equals(method.getName());
//	}

	@Override
	public boolean matches(Method method, Class<?> claszz, Object[] args) {
		System.out.println("调用MethodMatcher#matches()，对" + claszz.getName() + "的" + method.getName() + "方法进行动态检查（检查方法入參的实际值）");
		return Arrays.asList(params).contains(args[0]);
	}

}
