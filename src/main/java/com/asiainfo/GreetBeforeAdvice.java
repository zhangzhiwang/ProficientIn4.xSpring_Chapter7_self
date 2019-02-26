package com.asiainfo;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * 打招呼的前置增强
 * 
 * @author zhangzhiwang
 * @date 2019年2月22日 下午3:27:04
 */
@Component
public class GreetBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method paramMethod, Object[] paramArrayOfObject, Object paramObject) throws Throwable {
		System.out.println("hello " + paramArrayOfObject[0] + "!");
	}

}
