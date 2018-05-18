package com.wangjun.thread;
/*
 * 构造一个死锁
 * 死锁最典型的案例就是两个线程互相等待对方的锁
 */
public class DeadLockTest {

	public static void main(String[] args) {
		ThreadA t1 = new ThreadA();
		ThreadB t2 = new ThreadB();
		t1.t = t2;
		t2.t = t1;
		t1.start();
		t2.start();
	}
	
	static class ThreadA extends Thread {
		ThreadB t;
		ThreadA(){
			
		}
		@Override
		public void run() {
			testA();
		}
		
		public synchronized void testA() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(t) {
				System.out.println("testA");
			}
		}
	}
	
	static class ThreadB extends Thread {
		ThreadA t;
		ThreadB(){
		}
		@Override
		public void run() {
			testB();
		}
		public synchronized void testB() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(t) {
				System.out.println("testB");
			}
		}
	}

}
