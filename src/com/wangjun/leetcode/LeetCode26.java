package com.wangjun.leetcode;

import java.util.Arrays;

/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素x推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
public class LeetCode26 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());  
		minStack.pop();
		System.out.println(minStack.top());      
		System.out.println(minStack.getMin());  
	}
	
	
	//解法2 84ms  98.67%
	static class MinStack2 {
		
		private int[] stack;
		private int min;
		private int top;
		
		private int MAX_LENGTH = 100;

	    /** initialize your data structure here. */
	    public MinStack2() {
	        stack = new int[MAX_LENGTH];
	        top = 0;
	    }
	    
	    public void push(int x) {
	    	if(top >= MAX_LENGTH) {
	    		MAX_LENGTH = MAX_LENGTH << 1;
	    		stack = Arrays.copyOf(stack, MAX_LENGTH);
	    	}
	        stack[top++] = x;
	        if(top == 1) {
	        	min = x;
	        }else if(min > x) {
	        	min = x;
	        }
	    }
	    
	    public void pop() {
	    	int x = stack[top - 1];
	    	if(min == x) {
	    		for(int i = 0; i < top -1; i++) {
	    			if(i == 0) {
	    				min = stack[i];
	    			}else {
	    				if(min > stack[i]) {
	    					min = stack[i];
	    				}
	    			}
	    		}
	    	}
	    	top--;
	    }
	    
	    public int top() {
	        return stack[top - 1];
	    }
	    
	    public int getMin() {
	        return min;
	    }
	}
	
	//解法1  265ms  15.56%
	static class MinStack {
		
		private int[] stack;
		private int[] sortArray;
		private int top;
		private int topArray;
		
		private int MAX_LENGTH = 100;

	    /** initialize your data structure here. */
	    public MinStack() {
	        stack = new int[MAX_LENGTH];
	        sortArray = new int[MAX_LENGTH];
	        top = 0;
	        topArray = 0;
	    }
	    
	    public void push(int x) {
	    	if(top >= MAX_LENGTH) {
	    		MAX_LENGTH = MAX_LENGTH << 1;
	    		stack = Arrays.copyOf(stack, MAX_LENGTH);
	    		sortArray = Arrays.copyOf(sortArray, MAX_LENGTH);
	    	}
	        stack[top++] = x;
	        //插入排序插入排序数组中
	        int tem = topArray - 1;
	        if(topArray == 0) {
	        	sortArray[topArray++] = x;
	        	return;
	        }
	        while(tem >= 0 && x > sortArray[tem]) {
	        	sortArray[tem + 1] = sortArray[tem];
	        	tem--;
	        }
	        sortArray[tem+1] = x;
	        topArray++;
	    }
	    
	    public void pop() {
	    	int x = stack[top - 1];
	    	for(int i = 0; i <= topArray; i++) {
	    		if(x == sortArray[i]) {
	    			System.arraycopy(sortArray, i + 1, sortArray, i, MAX_LENGTH - i - 1);
	    			break;
	    		}
	    	}
	    	topArray--;
	    	top--;
	    }
	    
	    public int top() {
	        return stack[top - 1];
	    }
	    
	    public int getMin() {
	        return sortArray[topArray - 1];
	    }
	}
}
