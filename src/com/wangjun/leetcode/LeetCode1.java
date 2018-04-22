package com.wangjun.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/** 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月4日 下午11:23:32 
 */
public class LeetCode1 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = solution.twoSum(nums, target);
		System.out.println(Arrays.toString(result));
		
	}

}

/*
   解法1,  用时：41ms
   给定一个整数数列，找出其中和为特定值的那两个数。
   你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
    		int[] result = {-1, -1};
        for(int i = 0; i < nums.length - 1; i++) {
        		for(int j = i + 1; j < nums.length; j++) {
        			if(target == ((nums[i] + nums[j]))) {
        				result[0] = i;
        				result[1] = j;
        			}
        		}
        }
        return result;
    }
	
	//解法2，使用HashMap  用时：7ms
	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.keySet().contains(target - nums[i])){
				return new int[]{map.get(target - nums[i]),i};
			}else{
				map.put(nums[i], i);
			}
		}
		return null;
    }
}
