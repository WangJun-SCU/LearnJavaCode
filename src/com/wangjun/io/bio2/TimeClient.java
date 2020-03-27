package com.wangjun.io.bio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author wangjun
 * @date 2020-03-26
 * @version 1.0
 */
public class TimeClient {
	public static void main(String[] args) {
		int port = 8080;
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket("127.0.0.1", port);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			out.println("QUERY TIME ORDER");
			out.flush();
			System.out.println("send order to server succeed");
			String resp = in.readLine();
			System.out.println("Now is:" + resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("client finally");
			if(out != null) {
				out.close();
				out = null;
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}
}
