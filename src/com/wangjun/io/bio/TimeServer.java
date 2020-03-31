package com.wangjun.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞式IO创建时间服务器
 * @author wangjun
 * @date 2020-03-25
 * @version 1.0
 */
public class TimeServer {
	public static void main(String[] args) throws IOException {
		int port = 8081;
		if(args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				//port采用默认值
			}
		}
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("server started, port:" + port);
			Socket socket = null;
			while(true) {
				socket = server.accept();
				//启动一个新线程处理请求
				System.out.println("start a thread, hostName:" + socket.getInetAddress().getHostName());
				new Thread(new TimeServerHandler(socket)).start();
			}
		} finally {
			if(server != null) {
				System.out.println("server close");
				server.close();
				server = null;
			}
		}
	}
}
