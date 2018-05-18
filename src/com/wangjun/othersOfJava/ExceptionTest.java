package com.wangjun.othersOfJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {

	public static void main(String[] args) {
		//处理runtime异常
		int a = 10;
		int b = 10;
		try {
			b = a / 0;
		}catch(ArithmeticException e) {
			e.printStackTrace();//输出该异常的跟踪栈信息
			System.out.println("打印message：" + e.getMessage());
			System.out.println("打印trace：" + e.getStackTrace());
		}
		
		//Checked异常必须被显式处理
		try {
			FileInputStream fis = new FileInputStream("test.md");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//使用throw主动抛出异常
		try {
			FileInputStream fis = new FileInputStream("test.md");
			if(fis.read() == 0) {
				throw new IOException("空文件");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//演示异常链，创建用户
	public void createSubscriber(int subId) throws BusinessException {
		try {
			//创建用户的逻辑......
			
		}catch(Exception e){
			//处理并保存原始异常...
			
			//抛出新的业务异常
			throw new BusinessException("用户创建失败");
		}
	}
	
	//自定义异常
	class BusinessException extends Exception {
		private static final long serialVersionUID = 1L;

		public BusinessException() {
			super();
		}
		
		public BusinessException(String str) {
			super(str);
		}
	}

}
