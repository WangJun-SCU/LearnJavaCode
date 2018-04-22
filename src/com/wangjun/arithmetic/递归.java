package com.wangjun.arithmetic;

public class 递归 {

	public static void main(String[] args) {
		
	}
	
	//n的阶乘
	public static int test(int n){
		if(n == 1){
			return 1;
		}else{
			return test(n-1) * n;
		}
	}
	//兔子产子
	public static int test2(int n){
		if(n == 1 || n == 2){
			return 1;
		}else{
			return test2(n - 1) + test2(n - 2);
		}
	}

}
