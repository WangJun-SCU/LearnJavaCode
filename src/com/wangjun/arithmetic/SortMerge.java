package com.wangjun.arithmetic;

import java.util.Arrays;

/*
排序算法：归并排序
 */
public class SortMerge {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10,12,90,99,999};
		System.out.println(Arrays.toString(merge2Arr(arr1, arr2)));
	}
	
	// 基础，合并两个有序数组
	public static int[] merge2Arr(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] res = new int[len1 + len2];
		int i = 0, j = 0;
		while(i < len1 || j < len2) {
			if(i == len1) {
				res[i + j] = arr2[j];
				j++;
			}else if(j == len2){
				res[i + j] = arr1[i];
				i++;
			}else if(arr1[i] < arr2[j]) {
				res[i + j] = arr1[i];
				i++;
			}else if(arr1[i] >= arr2[j]) {
				res[i + j] = arr2[j];
				j++;
			}
		}
		
		
		return res;
	}

}
