package com.wangjun.thread.IsReentrantLock;

/*
 * 不可重入锁设计
 */
public class Lock1 {
	private boolean lock = false;
	
	public synchronized void lock() throws InterruptedException {
		while(lock) {
			wait();
		}
		lock = true;
	}
	
	public synchronized void unLock() {
		lock = false;
		notify();
	}
}
