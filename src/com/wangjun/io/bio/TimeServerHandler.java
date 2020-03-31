package com.wangjun.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author wangjun
 * @date 2020-03-25
 * @version 1.0
 */
public class TimeServerHandler implements Runnable {
	
	private Socket socket;
	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			String currentTime =  null;
			String body = null;
			while(true) {
				System.out.println("start read data");
				body = in.readLine();
				if(body == null) {
					System.out.println("body is null");
					break;
				}
				System.out.println("server receive order:" + body);
				currentTime = "QUERY TIME ORDER".equals(body)? new Date(System.currentTimeMillis()).toString(): "BAD ORDER";
				out.println(currentTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(out != null) {
				out.close();
				out = null;
			}
			if(this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.socket = null;
			}
		}
	}

}
