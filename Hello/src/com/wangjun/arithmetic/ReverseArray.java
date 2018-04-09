package com.wangjun.arithmetic;

import java.util.Arrays;

/*
 * 倒置数组
 * {1, 2, 3, 4, 5, 6, 7, 8}
 * 变成
 * {8, 7, 6, 5, 4, 3, 2, 1}
 */
public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		ReverseArray ra = new ReverseArray();
		ra.reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void reverseArray(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while(start < end) {
			int tem = arr[start];
			arr[start] = arr[end];
			arr[end] = tem;
			start++;
			end--;
		}
	}

}
