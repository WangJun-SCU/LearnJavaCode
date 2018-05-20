package com.wangjun.thread.IsReentrantLock;

public class Lock2 {

	private boolean lock = false;  //记录是否有线程获得锁
	private Thread curThread = null;  //记录获得锁的线程
	private int lockCount = 0;  //记录加锁次数
	
	public synchronized void lock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		//如果已经加锁并且不是等当前线程，那么就等待
		while(lock && thread != curThread) {
			wait();
		}
		
		lock = true;  //线程获得锁
		lockCount++;  //加锁次数+1
		curThread = thread;  //获得锁的线程等于当前线程

	}
	
	public synchronized void unLock() {
		Thread thread = Thread.currentThread();
		// 如果是获得锁的线程调用unLock，那么加锁次数减一
		if(thread == curThread) {
			lockCount--;
			//所有的加锁都释放，通知其他线程可以获得锁了
			if(lockCount == 0) {
				notify();
			}
		}
	}
}
