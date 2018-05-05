package com.wangjun.othersOfJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * 读取其他进程的输出信息
 */
public class ReadFromProcess {

	public static void main(String[] args) throws IOException {
		// 1. 读取其他进程的数据
		// 运行javac命令，返回该命令的子进程
		Process p = Runtime.getRuntime().exec("javac");
		// 以p进程的错误流创建BufferedReader对象
		// 这个错误流对本程序是输入流，对p进程则是输出流
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String buff = null;
		while ((buff = br.readLine()) != null) {
			System.out.println(buff);
		}

		// 2. 将数据输出到其他程序
		Process p2 = Runtime.getRuntime().exec("java ReadStandard");
		PrintStream ps = new PrintStream(p2.getOutputStream());
		ps.println("普通字符串");
		ps.println(new ReadFromProcess());
		System.out.println(222);
	}
}

class ReadStandard {
	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner s = new Scanner(System.in); 
			PrintStream ps = new PrintStream(new FileOutputStream("out.md"))) {
			s.useDelimiter("\n");
			while (s.hasNext()) {
				ps.println("输入内容是：" + s.next());
			}
		}
	}
}
