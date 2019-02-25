package com.asiainfo;

import org.springframework.stereotype.Component;

@Component
public class WaiterImpl implements IWaiter {

	@Override
	public void serve1(String name) {
		System.out.println("serve1逻辑");
//		throw new RuntimeException("serve1的异常");
	}

	@Override
	public void serve2(String name) {
		System.out.println("serve2逻辑");
//		throw new RuntimeException("serve2的异常");
	}

}
