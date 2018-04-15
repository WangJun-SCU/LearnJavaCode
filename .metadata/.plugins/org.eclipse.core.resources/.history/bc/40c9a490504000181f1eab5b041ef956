package com.wangjun.arithmetic;

public class TestSortBubble {

	public static void main(String[] args) {
		int[] arr = {1,2,3,7,5,4};
	}
	
	public void sortBuddle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			boolean tag = false;
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					arr[j] = arr[j] ^ arr[j+1];
					arr[j+1] = arr[j] ^ arr[j+1];
					arr[j] = arr[j] ^ arr[j+1];
					tag = true;
				}
			}
			if(tag) {
				break;
			}
		}
	}

}
