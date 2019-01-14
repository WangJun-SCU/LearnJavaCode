package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjun
 * @date 2019-01-14
 * @version 1.0
 * 
 * 帕斯卡三角形
 * 
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class LeetCode67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
		
		//解法1 1ms 95%
	    public List<List<Integer>> generate(int numRows) {
	        if(numRows < 1) {
	        	return new ArrayList<List<Integer>>();
	        }
	        
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        List<Integer> item1 = new ArrayList<Integer>();
	        item1.add(1);
	        result.add(item1);
	        
	        for(int i = 2; i <= numRows; i++) {
	        	List<Integer> item2 = new ArrayList<Integer>();
	        	item2.add(1);
	        	for(int j = 2; j <= i - 1; j++) {
	        		item2.add(item1.get(j - 2) + item1.get(j - 1));
	        	}
	        	item2.add(1);
	        	result.add(item2);
	        	item1 = item2;
	        }
	        return result;
	    }
	}

}
