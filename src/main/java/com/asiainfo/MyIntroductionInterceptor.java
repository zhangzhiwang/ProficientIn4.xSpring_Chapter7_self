package com.asiainfo;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * 引介增强
 *
 * @author zhangzhiwang
 * @date 2019年2月25日 下午10:46:36
 */
@Component
public class MyIntroductionInterceptor extends DelegatingIntroductionInterceptor implements GreetSwitch {
	// 基于效率和线程安全的考虑，应该使用ThreadLocal，见课本p240
	private boolean isActive;

	@Override
	public void setGreetingActive(boolean active) {
		isActive = active;
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		if (!isActive) {
			return super.invoke(mi);
		}

		// 方法调用前逻辑
		long begin = Statics.begin();

		// 目标方法
		Object returnObj = super.invoke(mi);// 注：目标方法是父类的，因为引介增强是创建目标类的子类来达到目的的

		// 方法调用后逻辑
		Statics.end(begin);

		return returnObj;
	}
}
