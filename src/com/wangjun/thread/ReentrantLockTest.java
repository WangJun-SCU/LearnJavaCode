package com.wangjun.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		MyService service = new MyService();
		Thread t1 = new MyThread(service);
		Thread t2 = new MyThread(service);
		Thread t3 = new MyThread(service);
		Thread t4 = new MyThread(service);
		Thread t5 = new MyThread(service);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	//服务类
	static class MyService{
		ReentrantLock lock = new ReentrantLock();
		public void printInt() {
			lock.lock();//加锁
			for(int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
			lock.unlock();//释放锁
		}
	}
	
	//线程类
	static class MyThread extends Thread{
		private MyService service;
		public MyThread(MyService service) {
			this.service = service;
		}
		@Override
		public void run() {
			service.printInt();
		}
	}

}
