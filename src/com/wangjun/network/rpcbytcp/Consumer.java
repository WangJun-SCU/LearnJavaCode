package com.wangjun.network.rpcbytcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {
	
	public Consumer() throws Exception {
	}

	String interfaceName = SayHelloService.class.getName();

	// 需要远程执行的方法
	Method method = SayHelloService.class.getMethod("sayHello", String.class);
	// 需要传递到远端的参数
	Object[] args = { "hello" };
	Socket socket = new Socket("127.0.0.1", 1234);
	
	//将方法名和参数传递到远端
	public void putRpc() throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeUTF(interfaceName);
		output.writeUTF(method.getName());
		output.writeObject(method.getParameterTypes());
		output.writeObject(args);
	}
	
	//从远端读取方法的执行结果
	public void getRpc() throws Exception {
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		Object result = input.readObject();
		System.out.println(result);
	}
}
