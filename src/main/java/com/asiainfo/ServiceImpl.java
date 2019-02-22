package com.asiainfo;

public class ServiceImpl {
	public void met1() {
		// 最原始的方式。将一些和业务逻辑完全无关的统计信息耦合在业务代码里面
		System.out.println("开始记录时间...");
		long start = System.currentTimeMillis();
		try {
			System.out.println("met1执行业务逻辑");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("结束时间统计，共耗时" + (end - start) + "毫秒");
	}

	public void met2() {
		// 稍微高级点的就是把一些统计代码抽到其他类里面给封装起来，然后在被统计的方法里面去掉用，属于换汤不换药
		long start = Statics.begin();
		try {
			System.out.println("met2执行业务逻辑");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Statics.end(start);
	}
	
	public void met3() {
		// 最高级的方法就是将所有的与业务逻辑没有关系的横切代码全部去掉，用AOP织入进来
		try {
			System.out.println("met3执行业务逻辑");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
