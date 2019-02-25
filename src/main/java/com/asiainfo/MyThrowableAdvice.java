package com.asiainfo;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * 异常抛出增强
 *
 * @author zhangzhiwang
 * @date 2019年2月25日 下午9:49:53
 */
@Component
public class MyThrowableAdvice implements ThrowsAdvice {
	public void afterThrowing(Method targetMethod, Object[] targetMethodArgs, Object target, Exception e) {
		System.out.println("抛出异常的方法名为：" + targetMethod.getName());
		System.out.println("抛出异常的方法的第一个入参为：" + targetMethodArgs[0]);
		System.out.println("目标对象为：" + target);
		System.out.println("抛出的异常信息为：" + e.getMessage());
	}
}
