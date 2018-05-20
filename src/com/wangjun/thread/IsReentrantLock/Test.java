package com.wangjun.thread.IsReentrantLock;

public class Test {
	
	Lock2 lock = new Lock2();
	
	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		t.test1();
	}
	
	public void test1() throws InterruptedException {
		lock.lock();
		System.out.println("test1方法执行...调用test2方法");
		test2();
		lock.unLock();
	}
	
	public void test2() throws InterruptedException {
		lock.lock();
		System.out.println("test2方法执行...");
		lock.unLock();
	}
}
