package com.wangjun.network.rpcbytcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
	public Provider() throws Exception {

	}

	public void getInfo() throws Exception {
		ServerSocket server = new ServerSocket(1234);
		while(true)
		{
			Socket socket = server.accept();
			// 读取服务信息
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			String interfaceName = input.readUTF();
			String methodName = input.readUTF();
			Class<?>[] paramsTypes = (Class<?>[]) input.readObject();
			Object[] args = (Object[]) input.readObject();
			
			//执行调用
			Class serviceinterfaceclass = Class.forName(interfaceName);
			//TODO 取得服务实现的对象
			Object service = new SayHelloServiceImpl();
			Method method = serviceinterfaceclass.getMethod(methodName, paramsTypes);
			Object result = method.invoke(service, args);
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(result);
		}
	}
}
