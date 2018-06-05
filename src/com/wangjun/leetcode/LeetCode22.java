package com.wangjun.leetcode;

import java.util.Arrays;

/*
合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class LeetCode22 {

	public static void main(String[] args) {

	}
	
	// 解法2 注意是有序数组，合并排序  4ms  93.94%
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >=0 || j >= 0){
            if(i < 0){
                nums1[k--] = nums2[j--];
            }else if(j < 0){
                nums1[k--] = nums1[i--];
            }else if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else if(nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }
        }
    }
	
	//解法1  插入排序  7ms  20%
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++) {
        		int tem = nums2[i];
        		int j = m - 1;
        		while(j >= 0 && tem < nums1[j]) {
        			nums1[j+1] = nums1[j];
        			j--;
        		}
        		nums1[j+1] = tem;
        		m++;
        }
    }
	//解法2 new一个数组  7ms  20%
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] tem = Arrays.copyOf(nums1, nums1.length);
		int i = 0;
		int j = 0;
		int x = 0;
		while(i < m || j < n) {
			if(i < m && j < n) {
				if(tem[i] < nums2[j]) {
					nums1[x] = tem[i];
					x++;
					i++;
				}else {
					nums1[x] = nums2[j];
					x++;
					j++;
				}
			}else if(i < m) {
				nums1[x] = tem[i];
				x++;
				i++;
			}else {
				nums1[x] = nums2[j];
				x++;
				j++;
			}
		}
    }
}
