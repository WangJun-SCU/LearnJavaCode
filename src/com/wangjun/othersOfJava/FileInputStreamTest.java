package com.wangjun.othersOfJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 节点流演示
 */
public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {
		//读取文件
		FileInputStream fis = new FileInputStream("img.jpg");
		//写入文件
		FileOutputStream fos = new FileOutputStream(new File("img2.jpg"));
		//定义每次读取的字节数，保存在b中
		byte[] b = new byte[1024];
		//read方法返回实际读取的字节数
		int hasRead = 0;
		while((hasRead = fis.read(b)) > 0) {
			System.out.println("hasRead:" + hasRead);
			System.out.println(new String(b, 0, hasRead));
			fos.write(b, 0, hasRead);
		}
		fis.close();
	}

}
