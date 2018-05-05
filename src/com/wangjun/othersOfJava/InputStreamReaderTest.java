package com.wangjun.othersOfJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 字节流转字符流示例
 * System.in 是键盘输入，是InputStream的实例，因为键盘输入都是字符，所以转换成字符流操作更方便
 * 普通的Reader读取内容时依然不方便，可以包装成BufferedReader，利用BufferedReader的readLine()方法
 * 可以一次读取一行内容
 */
public class InputStreamReaderTest {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String buffer = null;
		while((buffer = br.readLine()) != null) {
			if(buffer.equals("exit")) {
				System.out.println("bye bye!");
				System.exit(1);
			}
			System.out.println("输入内容为：" + buffer);
		}
	}

}
