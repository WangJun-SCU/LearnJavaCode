package com.wangjun.arithmetic;

/*
 * 查找算法：二分法
 */
public class FindBy2 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		System.out.println(findBy2(nums, 1));
	}
	
	/**
	 * 二分查找的实现
	 * @param nums  有序数组
	 * @param target  查找的值
	 * @return  返回值所在的位置
	 */
	public static int findBy2(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int middle;
		while(start <= end) {//*
			middle = (start + end)/2;
			if(target > nums[middle]) {
				start = middle + 1;//*
			}else if(target < nums[middle]) {
				end = middle - 1;//*
			}else {
				return middle;
			}
		}
		return -1;
	}

}
