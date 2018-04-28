package com.wangjun.arithmetic;

public class PrintBinary {

	public static void main(String[] args) {
		printBinaryInt(-1);
	}
	
	//打印整数的补码
	static void printBinaryInt(int i) {
		for (int j = 31; j >= 0; j--)
			if (((1 << j) & i) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}

}
