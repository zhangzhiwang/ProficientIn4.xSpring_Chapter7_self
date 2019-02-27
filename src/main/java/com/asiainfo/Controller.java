package com.asiainfo;

import org.springframework.stereotype.Component;

@Component
public class Controller {
	private UserServiceImpl userServiceImpl;

	public void getUserCon(String name) {
		System.out.println("调用userServiceImpl查询");
		userServiceImpl.getUser(name);
		System.out.println("-----------------");
		userServiceImpl.mmm("");
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

}
