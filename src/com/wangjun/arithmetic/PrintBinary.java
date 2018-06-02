package com.wangjun.arithmetic;

public class PrintBinary {

	public static void main(String[] args) {
		printBinaryInt(-1);
		System.out.println();
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE * 10));
		System.out.println(Integer.MAX_VALUE * 2);
	}
	
	/*
	 * 打印负数的原码
	 */
	public void printYuanMa(int n) {
		
	}
	
	/*
	 * 打印整数的补码
	 * 计算机内计算位运算的时候就是拿补码去计算的(重点！)
	 * 所以只要用每一位和1做'与'运算，就可以判断这一位是不是1了
	 * 举个例子：
	 * -2的原码是10000000 0000000 00000000 00000010
	 * -2的反码是11111111 1111111 11111111 11111101
	 * -2的补码是11111111 1111111 11111111 11111110
	 * 
	 * 其实我们不关注他们的原码和反码！知道计算机运算的时候是拿补码计算的
	 * 因此他的第一位就是
	 * 11111111 1111111 11111111 11111110  & 
	 * 10000000 00000000 00000000 00000000
	 * 结果不是0，所以输出1，
	 * 第二位
	 * 11111111 1111111 11111111 11111110 &
	 * 01000000 00000000 00000000 00000000
	 * 结果也不是0，所以输出1
	 * 
	 * ...依次类推
	 * 
	 * 最后一位
	 * 11111111 1111111 11111111 11111110 &
	 * 00000000 00000000 00000000 00000001
	 * 结果是0，所以输出0。
	 */
	static void printBinaryInt(int i) {
		for (int j = 31; j >= 0; j--) {
			if (((1 << j) & i) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		}
	}

}
