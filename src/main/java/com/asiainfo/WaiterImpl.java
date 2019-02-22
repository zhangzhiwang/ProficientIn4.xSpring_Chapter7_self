package com.asiainfo;

public class WaiterImpl implements IWaiter {

	@Override
	public void serve1(String name) {
		System.out.println("serve1逻辑");
	}

	@Override
	public void serve2(String name) {
		System.out.println("serve2逻辑");
	}

}
