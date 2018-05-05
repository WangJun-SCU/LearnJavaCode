package com.wangjun.othersOfJava;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/*
 * 推回缓冲流测试
 * 如果文件中包含LeetCode就把LeetCode周边的字符打印出来
 */
public class PushbackReaderTest {

	public static void main(String[] args) throws IOException {
		//推回缓冲区的长度为64
		PushbackReader pr = new PushbackReader(new FileReader("README.md"), 64);
		char[] cbuf = new char[16];
		int hasRead = 0;
		String lastRead = "";
		while((hasRead = pr.read(cbuf)) > 0) {
			String str = new String(cbuf, 0, hasRead);
			if((lastRead + str).contains("LeetCode")) {
				//推回到缓冲区
				pr.unread(cbuf, 0, hasRead);
				//这一次会先读取缓冲区的内容
				hasRead = pr.read(cbuf);
				//打印字符
				System.out.println(new String(cbuf, 0 ,hasRead));
				System.out.println("lastRead:" + lastRead);
				pr.close();
				return;
			}else {
				lastRead = str;
			}
		}
		pr.close();
	}

}
