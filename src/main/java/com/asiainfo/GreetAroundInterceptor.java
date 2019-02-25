package com.asiainfo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 环绕增强
 *
 * @author zhangzhiwang
 * @date 2019年2月25日 下午9:17:17
 */
@Component
public class GreetAroundInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// 获取目标方法参数列表
		Object[] arguments = methodInvocation.getArguments();
		// 目标方法调用前的逻辑
		System.out.println("(around)hello " + arguments[0]);
		// 执行目标方法
		Object returnObj = methodInvocation.proceed();// returnObj为目标方法的返回值
		// 目标方法调用后的逻辑
		System.out.println("(around)Good bye " + arguments[0]);
		return returnObj;
	}

}
