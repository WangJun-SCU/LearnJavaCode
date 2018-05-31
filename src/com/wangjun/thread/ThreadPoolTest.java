package com.wangjun.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 演示线程池的使用
 */
public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//生产普通的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(6);
		// 第一种执行线程的方式
		threadPool.submit(new MyThread()); 
		// 第二种执行线程的方式，有返回值
		Future<String> result = threadPool.submit(new MyThread(), "返回值1"); 
		System.out.println(result.get());
		// 第三种执行线程的方式，传入Callable对象，有返回值
		Future<String> result2 = threadPool.submit(new MyThread2()); 
		System.out.println(result2.get());
		
		// 关闭线程池,不再接受新的任务，会将之前所有提交的任务执行完成，所有任务完成后，所有的线程死亡
		// 调用shutdownNow可以立马停止所有线程
		threadPool.shutdown();
		System.out.println("-----");
		// 生产可以延迟执行的线程池
		ScheduledExecutorService threadPool2 = Executors.newScheduledThreadPool(6);
		// 延迟1秒执行
		threadPool2.schedule(new MyThread(), 1, TimeUnit.SECONDS);
		// 延迟2秒后执行，每一秒循环执行一次
		// 是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，如果上一个任务执行完毕，
		// 则当前任务立即执行，如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行。
		threadPool2.scheduleAtFixedRate(new MyThread(), 2, 1, TimeUnit.SECONDS);
		// 是以上一个任务结束时开始计时，period时间过去后，立即执行。
		// 两个方法以不同的时间点作为参考
		threadPool2.scheduleWithFixedDelay(new MyThread(), 2, 1, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		threadPool2.shutdown();
	}

	static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("线程：" + Thread.currentThread().getName());
		}
	}
	
	static class MyThread2 implements Callable<String>{
		@Override
		public String call() throws Exception {
			System.out.println("线程：" + Thread.currentThread().getName());
			return "返回值2";
		}
	}

}
