package com.asiainfo;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;

public class MyComposablePointcut {
	public Pointcut getPointcut() {
		// 创建复合切点
		ComposablePointcut composablePointcut = new ComposablePointcut();
		// 创建用于交并运算的第一个切点
		Pointcut p1 = new ControlFlowPointcut(Controller.class, "getUserCon");
		// 创建用于交并运算的第二个切点
		Pointcut p2 = new MyPointcutAdvisor();
		return composablePointcut.intersection(p1).intersection(p2);// 两个切点做交集运算
	}
}
