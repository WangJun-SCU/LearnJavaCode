package com.wangjun.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionTest {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();
//		Thread t1 = new MyThread(service);
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		service.signal();
		
		//演示通知多个线程
		Thread tA = new MyThreadA(service);
		Thread tAA = new MyThreadAA(service);
		Thread tB = new MyThreadB(service);
		tAA.start();
		tA.start();
		tB.start();
		Thread.sleep(1000);
		service.signalA();
	}
	
	static class MyService{
		private ReentrantLock lock = new ReentrantLock();
		private Condition condition = lock.newCondition();
		//通知单个线程，需要为新建多个Condition对象
		private Condition conditionA = lock.newCondition();
		private Condition conditionB = lock.newCondition();
		//线程等待，进入阻塞
		public void await() {
			try {
				//和wait方法只能用在synchronized里面一样，调用await之前比如先调用Lock获取同步监视器
				//否则会报错java.lang.IllegalMonitorStateException
				lock.lock();
				System.out.println("await的时间为：" + System.currentTimeMillis());
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
				System.out.println("锁释放了！");
			}
		}
		//通知线程继续
		public void signal() {
			lock.lock();
			System.out.println("signal的时间为：" + System.currentTimeMillis());
			condition.signal();
			lock.unlock();
		}
		
		//演示 通知 单个线程
		public void awaitA() {
			try {
				//和wait方法只能用在synchronized里面一样，调用await之前比如先调用Lock获取同步监视器
				//否则会报错java.lang.IllegalMonitorStateException
				lock.lock();
				System.out.println("await的时间为：" + System.currentTimeMillis());
				conditionA.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
				System.out.println("A线程锁释放了！");
			}
		}
		public void awaitAA() {
			try {
				//和wait方法只能用在synchronized里面一样，调用await之前比如先调用Lock获取同步监视器
				//否则会报错java.lang.IllegalMonitorStateException
				lock.lock();
				System.out.println("await的时间为：" + System.currentTimeMillis());
				conditionA.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
				System.out.println("AA线程锁释放了！");
			}
		}
		public void awaitB() {
			try {
				//和wait方法只能用在synchronized里面一样，调用await之前比如先调用Lock获取同步监视器
				//否则会报错java.lang.IllegalMonitorStateException
				lock.lock();
				System.out.println("await的时间为：" + System.currentTimeMillis());
				conditionB.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
				System.out.println("B线程锁释放了！");
			}
		}
		public void signalA() {
			lock.lock();
			System.out.println("signalA的时间为：" + System.currentTimeMillis());
			conditionA.signal();
			lock.unlock();
		}
		public void signalB() {
			lock.lock();
			System.out.println("signalB的时间为：" + System.currentTimeMillis());
			conditionB.signal();
			lock.unlock();
		}
	}
	
	static class MyThread extends Thread{
		private MyService service;
		public MyThread(MyService service) {
			this.service = service;
		}
		@Override
		public void run() {
			service.await();
		}
	}
	
	static class MyThreadA extends Thread{
		private MyService service;
		public MyThreadA(MyService service) {
			this.service = service;
		}
		@Override
		public void run() {
			service.awaitA();
		}
	}
	
	static class MyThreadAA extends Thread{
		private MyService service;
		public MyThreadAA(MyService service) {
			this.service = service;
		}
		@Override
		public void run() {
			service.awaitAA();
		}
	}
	
	static class MyThreadB extends Thread{
		private MyService service;
		public MyThreadB(MyService service) {
			this.service = service;
		}
		@Override
		public void run() {
			service.awaitB();
		}
	}
	
	

}
