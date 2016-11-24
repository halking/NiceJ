package com.hal.jws;

import javax.jws.WebService;

import com.hal.jws.entity.User;

@WebService(endpointInterface="com.hal.jws.HelloWorld",serviceName="HelloWorld")
public class HelloWorldImpl  implements HelloWorld{

	public String sayHello(String params) {
		System.out.println("hello world");
		return "hello"+params;
	}

	public String sayToUser(User user) {
		System.out.println("hello "+user);
		return "Hello  "+user.getName()+",address:"+user.getAddress();
	}

}
