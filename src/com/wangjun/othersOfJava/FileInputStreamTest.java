package com.wangjun.othersOfJava;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		//读取文件
		FileInputStream fis = new FileInputStream("README.md");
		//定义每次读取的字节数，保存在b中
		byte[] b = new byte[12];
		//read方法返回实际读取的字节数
		int hasRead = 0;
		while((hasRead = fis.read(b)) > 0) {
			System.out.println("hasRead:" + hasRead);
			System.out.println(new String(b, 0, hasRead));
		}
		fis.close();
	}

}
