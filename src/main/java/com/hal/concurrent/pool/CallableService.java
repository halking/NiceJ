package com.hal.concurrent.pool;

import java.util.concurrent.Callable;

public class CallableService<T> implements Callable<T> {
	private int age;
	public CallableService(int age) {
		super();
		this.age=age;
	}
	@Override
	public T call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" is running!");
		return  (T) ("返回值是："+age);
	}
}
