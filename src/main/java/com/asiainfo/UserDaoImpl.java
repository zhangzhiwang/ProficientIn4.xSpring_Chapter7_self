package com.asiainfo;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl {
	public void getUserByName(String name) {
		System.out.println("查询数据库获取用户,name = " + name);
	}
	
	public void getUserById() {
		System.out.println("查询数据库,id=1111111111111");
	}
}
