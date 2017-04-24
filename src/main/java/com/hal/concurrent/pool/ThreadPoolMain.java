package com.hal.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.hal.common.utils.Global;

public class ThreadPoolMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < Global.FIVE_COUNT; i++) {
			executorService.execute(new CachePoolRunnable("i--"+i));
		}
		Thread.sleep(2000);
		System.out.println("\n\n");
		for (int i = 0; i < Global.FIVE_COUNT; i++) {
			executorService.execute(new CachePoolRunnable("i--"+i));
		}
	}

}
