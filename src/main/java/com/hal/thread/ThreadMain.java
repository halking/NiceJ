/**
 * @date:2017年1月18日
 * @author:D1M
 */
package com.hal.thread;

/**
 * @author D1M
 *
 */
public class ThreadMain {

	/**
	 * @description:
	 *@param args
	 *void
	 *@author D1M
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new MyThread("mythread"),"mythread");
		thread.start();
		System.out.println(thread.getName());
		System.out.println("main thread is running!" +Thread.currentThread().getName());
	}
	
}
