package com.wangjun.arithmetic;

import java.util.Arrays;

/*
 * 计数排序算法
 * 给定一个数组，且知道所有值得范围是[m,n],使用计数排序算法可以使时间复杂度为O(N)
 * 
 * 思路：
 * 新建一个长度为n-m+1的临时数组
 * 遍历待排序数组，它的值-m作为临时数组下角标，这个位置的值加1
 * 遍历结束，临时数组就存储了每个值得个数
 * 最后将它展开赋值给原数组
 * 
 * 参考：https://blog.csdn.net/gaoruxue918/article/details/61467416
 */
public class SortCount {

	public static void main(String[] args) {
		//测试
		int[] arr = {1,4,6,7,5,4,3,2,1,4,5,10,9,10,3};
		sortCount(arr, 1, 10);
		System.out.println(Arrays.toString(arr));
	}
	
	//计数排序的初步实现，使用了多余的空间
	//TODO 优化算法，不使用多余的空间
	public static void sortCount(int[] arr, int m, int n) {
		int len = arr.length;
		int[] tem = new int[n - m + 1];
		for(int i = 0; i < len; i++) {
			tem[arr[i] - m] += 1;
		}
		for(int i = 0, index = 0; i < tem.length; i++) {
			int item = tem[i];
			while(item-- != 0) {
				arr[index++] = i + m;
			}
		}
	}

}
