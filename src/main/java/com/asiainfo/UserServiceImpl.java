package com.asiainfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public void getUser(String name) {
		System.out.println("调用userDaoImpl#getUserByName()");
		userDaoImpl.getUserByName(name);
		System.out.println("调用userDaoImpl#getUserById()");
		userDaoImpl.getUserById();
	}
	
	public void mmm(String s) {
		System.out.println("mmm...");
	}
}
