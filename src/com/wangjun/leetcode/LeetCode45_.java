package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
题目：合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class LeetCode45_ {
	public static void main(String[] args) {
		
	}
	
	   
	class Solution {
		//TODO 合并区间 解法1  还没通过
	    public List<Interval> merge(List<Interval> intervals) {
	    	List<Interval> result = new ArrayList<>();
	    	if(null == intervals || intervals.size() == 0) {
	    		return result;
	    	}
	    	int min = intervals.get(0).start;
	    	int max = intervals.get(0).end;
	    	//第一次遍历，找到区间
	        for(Interval item: intervals) {
	        	min = item.start < min? item.start : min;
	        	max = item.end > max? item.end : max;
	        }
	        
	        int[] nums = new int[max - min];
	        //第二次遍历，区间涂色
	        for(Interval item: intervals) {
	        	int start = item.start;
	        	int end = item.end;
	        	for(int i = start; i < end; i++) {
	        		nums[i - min] = 1;
	        	}
	        	if(start == end) {
	        		if(start == max) {
	        			nums[start - min - 1] = nums[start - min - 1] == 1? 1 : 2;
	        		}else {
	        			nums[start - min] = nums[start - min] == 1? 1 : 2;
	        		}
	        	}
	        }
	        //第三次遍历，取出涂色区间
	        int startTem = -1;
	        int endTem = -1;
	        for(int i = 0; i < nums.length; i++) {
	        	if(nums[i] == 2) {
	        		Interval item = new Interval(i + min, i + min);
        			result.add(item);
	        	}else if(nums[i] == 1) {
	        		if(startTem == -1) {
	        			startTem = i;
	        			endTem = i;
	        		}else {
	        			endTem = i;
	        		}
	        	}else{
	        		if(startTem != -1 && endTem != -1) {
	        			Interval item = new Interval(startTem + min, endTem + min + 1);
	        			result.add(item);
	        			startTem = endTem = -1;
	        		}
	        	}
	        }
	        if(startTem != -1 && endTem != -1) {
    			Interval item = new Interval(startTem + min, endTem + min + 1);
    			result.add(item);
    		}
	        return result;
	    }
	}
	
	class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
}
