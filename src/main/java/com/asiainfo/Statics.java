package com.asiainfo;

public class Statics {
	public static long begin() {
		System.out.println("开始统计的一些其他准备代码...");
		System.out.println("开始统计...");
		return System.currentTimeMillis();
	}
	
	public static void end(long start) {
		System.out.println("结束统计的准备代码...");
		System.out.println("统计结束，共耗时" + (System.currentTimeMillis() - start) + "毫秒");
	}
}
