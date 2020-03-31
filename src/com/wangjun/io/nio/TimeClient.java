package com.wangjun.io.nio;

/**
 * @author wangjun
 * @date 2020-03-30
 * @version 1.0
 */
public class TimeClient {
	
	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001");
		Thread t2 = new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-002");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("执行2个线程耗费：" + (System.currentTimeMillis() - start));
	}

}
