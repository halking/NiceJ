package com.hal.thread;

public class MyThread implements Runnable {
	
	private String name;
	public MyThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("inner thread is running!");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
