package com.wangjun.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskTest extends RecursiveTask<Integer>{
	
	private static final int THRESHOLD = 2;  // 阈值
	private int start;
	private int end;
	
	public ForkJoinTaskTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		int sum = 0;
		 if(end - start < THRESHOLD) {
			 System.out.println(Thread.currentThread().getName() + ":" + start + "-" + end);
			 for(int i = start; i <= end; i++) {
				 sum += i;
			 }
		 }else {
			 // 任务大于阈值，拆分子任务
			 int middle = start + (end - start)/2;
			 ForkJoinTaskTest task1 = new ForkJoinTaskTest(start, middle);
			 ForkJoinTaskTest task2 = new ForkJoinTaskTest(middle + 1, end);
			 // 执行子任务
			 task1.fork();
			 task2.fork();
			 // 等待子任务执行完成，并得到其结果
			 int result1 = task1.join();
			 int result2 = task2.join();
			 // 合并子任务
			 sum = result1 + result2;
		 }
		return sum;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int start = 1;
		int end = 10;
		ForkJoinTaskTest task = new ForkJoinTaskTest(start, end);
		// 用来执行ForkJoinTask
		ForkJoinPool pool = new ForkJoinPool();
		// 执行任务
		Future<Integer> result = pool.submit(task);
		System.out.println("最后的结果为：" + result.get());
	}

}
