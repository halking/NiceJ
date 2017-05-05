package com.hal.concurrent.pool;

import java.util.concurrent.Callable;

public class CallableService<T> implements Callable<T> {
	
	private int age;
	
	public CallableService(int age) {
		// TODO Auto-generated constructor stub
		super();
		this.age=age;
	}
	@Override
	public T call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		return  (T) ("返回值是："+age);
	}

}
