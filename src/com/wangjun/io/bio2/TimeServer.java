package com.wangjun.io.bio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 伪异步阻塞式IO创建时间服务器
 * 
 * @author wangjun
 * @date 2020-03-26
 * @version 1.0
 */
public class TimeServer {
	public static void main(String[] args) throws IOException {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// port采用默认值
			}
		}

		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("server started, port:" + port);
			Socket socket = null;
			// 创建线程池
			ExecutorService executor = Executors.newFixedThreadPool(20);
			while (true) {
				socket = server.accept();
				// 使用线程池处理请求
				System.out.println("use thread pool handler, hostName:" + socket.getInetAddress().getHostName());
				executor.submit(new TimeServerHandler(socket));
			}
		} finally {
			if (server != null) {
				System.out.println("server close");
				server.close();
				server = null;
			}
		}
	}
}
