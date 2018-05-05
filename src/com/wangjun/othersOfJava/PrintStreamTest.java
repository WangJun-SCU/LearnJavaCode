package com.wangjun.othersOfJava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * 处理流演示
 * 程序使用了PrintStream包装了FileOutputStream节点流输出流，使用println输入字符和对象
 * PrintStream输出功能非常强大，我们平时常用的System.out.println()就是使用的PrintStream
 */
public class PrintStreamTest {

	public static void main(String[] args) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("print.md");
		PrintStream ps = new PrintStream(fos);
		ps.println("test1");
		ps.println("test2");
		ps.println(new PrintStreamTest());
	}

}
