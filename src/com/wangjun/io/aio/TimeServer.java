package com.wangjun.io.aio;
/**
 * @author wangjun
 * @date 2020-04-01
 * @version 1.0
 */
public class TimeServer {

	public static void main(String[] args) {
		int port = 8080;
		AsynTimeServerHandler timeServer = new AsynTimeServerHandler(port);
		new Thread(timeServer, "AIO-AsynTimeServerHandler-001").start();
	}

}
