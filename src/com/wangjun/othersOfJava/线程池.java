package com.wangjun.othersOfJava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class 线程池 {

	public static void main(String[] args) throws Exception{
		
		//使用Executors创建容量为6的线程池
		ExecutorService es = Executors.newFixedThreadPool(6);
		
		//向线程池提交两个线程
		es.submit(new PoolThreadTest());
		es.submit(new PoolThreadTest());
		
		//提交有返回值的线程，返回值为submit的第二个参数"f1"
		//通过f1.get() 获取返回值
		Future<String> f1 = es.submit(new PoolThreadTest(), "f1");
		
		//提交Callable对象，带有返回值
		//通过f2.get() 获取返回值
		Future<String> f2 = es.submit(new PoolThreadTest2());
		
		//关闭线程池
		es.shutdown();
		
		//----------------------------->
		//使用ForkJoinPool创建线程池
		ForkJoinPool pool = new ForkJoinPool();
		//提交可分解的task任务
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		//关闭线程池
		pool.shutdown();
	}

}
class PoolThreadTest implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(200);
				System.out.println("ThreadName:" + Thread.currentThread().getName() + ",i:" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class PoolThreadTest2 implements Callable<String> {
	@Override
	public String call() throws Exception {
		for(int i = 0; i < 5; i++) {
			Thread.sleep(200);
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		return "Thread implements Callable";
	}
}
class PrintTask extends RecursiveAction {
	
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	//打印从start到end的任务
	public PrintTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end - start < THRESHOLD) {
			for(int i = start; i < end; i++) {
				System.out.println(Thread.currentThread().getName() + ",i的值：" + i);
			}
		}else {
			//要打印的树超过50个时，拆分成两个小任务
			int middle = (start + end) / 2;
			System.out.println("--------------");
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个小任务
			left.fork();
			right.fork();
		}
	}
	
}









