package com.wangjun.io.aio;

public class TimeClient {
	
	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		
		new Thread(new AsynTimeClientHandler("127.0.0.1", port), "AsynTimeClientHandler-001").start();
	}

}
