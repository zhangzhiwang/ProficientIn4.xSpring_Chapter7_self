package com.asiainfo;

import org.springframework.aop.ClassFilter;
import org.springframework.stereotype.Component;

/**
 * 自定义类过滤器（切点的一部分）
 * 
 * @author zhangzhiwang
 * @date 2019年2月26日 下午2:31:50
 */
@Component
public class MyClassFilter implements ClassFilter {

	@Override
	public boolean matches(Class<?> paramClass) {
		return IWaiter.class.isAssignableFrom(paramClass);// ClassA.isAssignableFrom(ClassB)  ClassB是不是和ClassA相同或者是ClassA子类（接口）
	}

}
