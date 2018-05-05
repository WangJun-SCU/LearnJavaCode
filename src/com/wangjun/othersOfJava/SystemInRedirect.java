package com.wangjun.othersOfJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * 将System.out重定向到文件，而不是屏幕
 */
public class SystemInRedirect {

	public static void main(String[] args) throws FileNotFoundException {
		// 重定向标准输出
		PrintStream ps = new PrintStream(new FileOutputStream("out.md"));
		// 将标准输出重定向到ps流
		System.setOut(ps);
		// 后面打印的内容就会打印到ps中，而不是Console
		System.out.println("test1");
		System.out.println(new SystemInRedirect());

		// 重定向标准输入
		FileInputStream fis = new FileInputStream("test.md");
		System.setIn(fis);
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		while (s.hasNext()) {
			System.out.println("获取到的输入内容是：" + s.next());
		}
		s.close();
	}

}
