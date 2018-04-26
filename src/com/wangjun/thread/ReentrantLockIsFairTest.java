package com.wangjun.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockIsFairTest {
	public static void main(String[] args) {
		//公平锁/非公平锁测试  控制传入的isFair
		MyService service = new MyService(true);
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "运行了");
				service.test();
			};
		};
		Thread[] threadArr = new Thread[10];
		for(int i = 0; i < 10; i++) {
			threadArr[i] = new Thread(runnable);
		}
		for(int i = 0; i < 10; i++) {
			threadArr[i].start();
		}
	}
	
	static class MyService{
		private ReentrantLock lock;
		public MyService(boolean isFair) {
			lock  = new ReentrantLock(isFair);
		}
		public void test() {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "获得锁！");
			lock.unlock();
		}
	}
}
