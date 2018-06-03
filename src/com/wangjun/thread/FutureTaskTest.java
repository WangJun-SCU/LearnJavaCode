package com.wangjun.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

	public static void main(String[] args) {

	}

	/*
	 * 当一个线程需要等待另外一个线程把某个任务执行完成后它才能继续执行
	 */
	private String executionTask(final String taskName) {
		while (true) {
			Future<String> future = taskCache.get(taskName);
			if (null == future) {
				Callable<String> task = new Callable<String>() {
					public String call() {
						return taskName;
					}
				};
				FutureTask<String> futureTask = new FutureTask<>(task);
				future = taskCache.putIfAbsent(taskName, futureTask);
				if (null == future) {
					future = futureTask;
					futureTask.run();
				}
			}
			try {
				return future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
