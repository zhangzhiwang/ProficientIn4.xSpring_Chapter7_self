package com.asiainfo;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * 打招呼的后置增强
 * 
 * @author zhangzhiwang
 * @date 2019年2月22日 下午3:27:04
 */
@Component
public class GreetAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Good bye " + args[0] + "!");
	}

}
