package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
给定两个数组，写一个方法来计算它们的交集。

例如:
给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

注意：
   输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
   我们可以不考虑输出结果的顺序。
*/
public class LeetCode7 {

	public static void main(String[] args) {
		
		int[] arr1 = {1};
		int[] arr = {1};
		int[] arr2 = new LeetCode7().intersect3(arr, arr1);
		System.out.println(Arrays.toString(arr2));

	}
	
	// 解法1  用时：14ms
	public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>(); 
        
        for(int i = 0; i < nums1.length; i++){
        	for(int j = 0; j < nums2.length; j++){
        		if(nums1[i] == nums2[j]){
        			resultList.add(nums1[i]);
        			System.arraycopy(nums2, j + 1, nums2, j, nums2.length - j - 1);
        			int[] temnums2 = new int[nums2.length - 1];
        			System.arraycopy(nums2, 0, temnums2, 0, nums2.length  - 1);
        			nums2 = temnums2;
        			break;
        		}
        	}
        }
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++){
        	result[i] = resultList.get(i);
        }
		
		return result;
    }
	
	//解法2，使用hashMap，value的值保存值的个数   用时：7ms
	public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>(); 
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
        	if(map.keySet().contains(nums1[i])){
        		map.put(nums1[i], map.get(nums1[i]) + 1);
        	}else{
        		map.put(nums1[i], 1);
        	}
        }
        
        for(int i = 0; i < nums2.length; i++){
        	if(map.keySet().contains(nums2[i]) && (map.get(nums2[i]) > 0)){
        		resultList.add(nums2[i]);
        		map.put(nums2[i], map.get(nums2[i]) - 1);
        	}
        }
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++){
        	result[i] = resultList.get(i);
        }
		
		return result;
    }
	
	// 解法3，先排序，再比较  用时5ms
	public int[] intersect3(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
        	if(nums1[i] > nums2[j]){
        		j++;
        	}else if(nums1[i] == nums2[j]){
        		resultList.add(nums1[i]);
        		i++;
        		j++;
        	}else{
        		i++;
        	}
        }
        
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++){
        	result[i] = resultList.get(i);
        }
		
		return result;
    }

}
