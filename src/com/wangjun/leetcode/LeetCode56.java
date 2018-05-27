package com.wangjun.leetcode;

import java.util.HashSet;

/*
题目：有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class LeetCode56 {
	public static void main(String[] args) {
		
	}
	
	class Solution {
		//解法2  discuss区解法1的合并版 思想一样
		public boolean isValidSudoku2(char[][] board) {
		    for(int i = 0; i<9; i++){
		        HashSet<Character> rows = new HashSet<Character>();
		        HashSet<Character> columns = new HashSet<Character>();
		        HashSet<Character> cube = new HashSet<Character>();
		        for (int j = 0; j < 9;j++){
		            if(board[i][j]!='.' && !rows.add(board[i][j]))
		                return false;
		            if(board[j][i]!='.' && !columns.add(board[j][i]))
		                return false;
		            int RowIndex = 3*(i/3);
		            int ColIndex = 3*(i%3);
		            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
		                return false;
		        }
		    }
		    return true;
		}
		
		//解法1 依次判断每一行，每一列，每一组  33ms  37.78%
	    public boolean isValidSudoku(char[][] board) {
	        
	    	for(int i = 0; i < 9; i++) {
	    		//判断每一行是否合法
	    		char[] arr = board[i];
	    		if(!isValidHelper(arr)) {
	    			return false;
	    		}
	    		
	    		//判断每一列是否合法
	    		char[] arr2 = new char[9];
	    		for(int j = 0; j < 9; j++) {
	    			arr2[j] = board[j][i];
	    		}
	    		if(!isValidHelper(arr2)) {
	    			return false;
	    		}
	    		
	    		//判断每一组是否合法
	    		int x = i/3 * 3;
	    		int y = i%3 * 3;
	    		char[] arr3 = new char[9];
	    		int j = 0;
	    		for(int m = x; m < x + 3; m++) {
	    			for(int n = y; n < y + 3; n++) {
	    				arr3[j++] = board[m][n];
	    			}
	    		}
	    		if(!isValidHelper(arr3)) {
	    			return false;
	    		}
	    	}
	    	
	    	return true;
	    }
	    
	    public boolean isValidHelper(char[] arr) {
	    	HashSet<Character> set = new HashSet<>();
	    	for(int i = 0; i < arr.length; i++) {
	    		if(set.contains(arr[i]) && arr[i] != '.') {
	    			return false;
	    		}
	    		set.add(arr[i]);
	    	}
	    	return true;
	    }
	}
}
