package com.wangjun.io.nio;
/**
 * @author wangjun
 * @date 2020-03-30
 * @version 1.0
 */
public class TimeServer {
	
	public static void main(String[] args) {
		int port = 8080;
		
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO_MultiplexerTimeServer-001").start();
	}

}
