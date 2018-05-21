package com.wangjun.arithmetic;

import java.util.Arrays;

/*
 * 快速排序
 */
public class SortQuick {

	public static void main(String[] args) {
		int[] arr = {2,3,7,5,43,8,9,0,3,1};
		int[] arr1 = {5,7};
		SortQuick ss = new SortQuick();
		ss.sortQuick(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void sortQuick(int[] arr) {
		sortHelper(arr, 0, arr.length - 1);
	}
	
	public void sortHelper(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		int middle = arr[(left+right)/2];
		while(left < right) {
			/*
			 * ? left不会越界么
			 * 不会，因为它最多走到middle的位置，就相等了，不满足while条件；
			 * 就算left和right都与middle相等然后交换了，剩下的交给递归去做
			 */
			while(middle > arr[left]) {
				left++;
			}
			while(middle < arr[right]) {
				right--;
			}
			if(left < right) {
				int tem = arr[left];
				arr[left] = arr[right];
				arr[right] = tem;
				left++;
				right--;
			}
		}
		/*
		 * ? 为啥要有这一步
		 * 考虑到这种情况 7 5 3 排好序后是 3 5 7 这时left=right=1
		 * 如果不让left++，那么左边和右边递归排序就重复了 5 这个值
		 * 由于是同步的，右边先排好后，中间这个值可能已经不是5了
		 * 还可能导致迭代死循环
		 * ？为什么只能left++，不能right--
		 * 考虑一下排序1 2，middle=0, 排好之后left=right=0；right- 1 = -1,明显不对了！
		 * 问题就出在求middle的时候，middle永远取不到最后一个值，而能取到第一个值，所以left++不会越界。
		 */
		if(left == right) {
			left++;
		}
		if(left < end) {
			sortHelper(arr,left,end);
		}
		if(right > start) {
			sortHelper(arr, start, right);
		}
	}
}
