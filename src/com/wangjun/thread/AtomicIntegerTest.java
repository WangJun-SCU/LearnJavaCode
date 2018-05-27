package com.wangjun.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	private static int n = 0;
	private static AtomicInteger n2 = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		test1();
		test2();
	}

	// i++引发的线程问题
	public static void test1() throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					n++;
				}
			};
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					n++;
				}
			};
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("最终n的值为：" + n);
	}

	// 使用AtomicInteger解决原子性问题
	public static void test2() throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					n2.incrementAndGet();
				}
			};
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					n2.incrementAndGet();
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("最终n2的值为：" + n2.toString());
	}

}
