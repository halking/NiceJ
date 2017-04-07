package com.hal.thread.lock;

public class LockThreadA extends Thread {
	private MyLock myLock;

	public LockThreadA(MyLock myLock) {
		this.myLock = myLock;
	}
	@Override
	public void run() {
		myLock.TestLock();
	}
}
