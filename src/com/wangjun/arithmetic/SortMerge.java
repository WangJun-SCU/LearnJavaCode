package com.wangjun.arithmetic;

import java.util.Arrays;

/*
排序算法：归并排序
参考：
https://blog.csdn.net/y999666/article/details/50942604
 */
public class SortMerge {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,8,10,12,90,99,999};
		System.out.println(Arrays.toString(merge2Arr(arr1, arr2)));
		
		// 测试递归合并排序
		int[] arr3 = {3,4,21,5,6,7,8,9,3,4,5,1,2};
		SortMerge sm = new SortMerge();
		sm.sortMergeIteration(arr3);
		System.out.println(Arrays.toString(arr3));
	}
	
	// 基础，合并两个有序数组
	public static int[] merge2Arr(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[] res = new int[len1 + len2];
		int i = 0, j = 0, k = 0;
		while(i < len1 || j < len2) {
			if(i < len1 && j < len2) {
				res[k++] = arr1[i] < arr2[j]? arr1[i++] : arr2[j++];
			}else if(i < len1) {
				res[k++] = arr1[i++];
			}else {
				res[k++] = arr2[j++];
			}
		}
		return res;
	}
	// 归并排序，非递归实现(迭代)
	public void sortMergeIteration(int[] nums) {
		int len = 1;
		while(len < nums.length) {
			for(int i = 0; i < nums.length; i += len * 2) {
				sortMergeIterationHelper(nums, i, len);
			}
			len *= 2;
		}
	}
	/**
	 * 辅助函数
	 * @param nums  原数组
	 * @param start 从start位置开始
	 * @param len  本次合并的两个数组的长度
	 */
	public void sortMergeIterationHelper(int[] nums, int start, int len) {
		int[] tem = new int[len * 2];
		int i = start;
		int j = start + len;
		int k = 0;
		while(i < start + len || (j < start + len + len && j < nums.length)) {
			if(i < start + len && (j < start + len + len && j < nums.length)) {
				tem[k++] = nums[i] < nums[j]? nums[i++] : nums[j++];
			}else if(i < start + len && i < nums.length) {
				tem[k++] = nums[i++];
			}else if(j < start + len + len && j < nums.length){
				tem[k++] = nums[j++];
			}else {
				break;
			}
		}
		int right = start + len + len;
		int index = 0;
		while(start < nums.length && start < right) {
			nums[start++] = tem[index++];
		}
	}
	// 归并排序，递归实现
	public void sortMergeRecursion(int[] nums) {
		sortMergeRecursionHelper(nums, 0, nums.length - 1);
	}
	public void sortMergeRecursionHelper(int[] nums,int left, int right) {
		if(left == right) return;  // 当待排序的序列长度为1时，递归开始回溯，进行merge
		int middle = left + (right - left) / 2;
		sortMergeRecursionHelper(nums, left, middle);
		sortMergeRecursionHelper(nums, middle + 1, right);
		mergeArr2(nums, left, middle, right);
	}
	public void mergeArr(int[] nums, int left, int middle, int right) {
		// 分为两个有序数组[left, middle]和[middle + 1, right]
		int[] tem1 = new int[middle - left + 1];
		int[] tem2 = new int[right - middle];
		// 拷贝两个临时数组
		for(int i = left; i <= middle; i++) {
			tem1[i - left] = nums[i];
		}
		for(int i = middle + 1; i <= right; i++) {
			tem2[i - middle - 1] = nums[i];
		}
		// 根据这两个数组进行合并排序，并放入nums数组中的left-right位置
		int i = 0, j = 0, k = left;
		while(i < tem1.length || j < tem2.length) {
			if(i < tem1.length && j < tem2.length) {
				nums[k++] = tem1[i] < tem2[j]? tem1[i++] : tem2[j++];
			}else if(i < tem1.length) {
				nums[k++] = tem1[i++];
			}else {
				nums[k++] = tem2[j++];
			}
		}
	}
	// 也可以使用一个辅助数组
	public void mergeArr2(int[] nums, int left, int middle, int right) {
		int[] tem = new int[right - left + 1];
		int i = left, j = middle + 1, k = 0;
		while(i <= middle || j <= right) {
			if(i <= middle && j <= right) {
				tem[k++] = nums[i] < nums[j]? nums[i++] : nums[j++];
			}else if(i <= middle) {
				tem[k++] = nums[i++];
			}else {
				tem[k++] = nums[j++];
			}
		}
		// 将辅助数组数据写入原数组
		int index = 0;
		while(left <= right) {
			nums[left++] = tem[index++];
		}
	}
	

}
