package com.wangjun.leetcode;

/*
第一个错误的版本
你是产品经理，目前正在领导一个团队开发一个新产品。不幸的是，您的产品的最新版本没有通过质量检查。
由于每个版本都是基于之前的版本开发的，所以错误版本之后的所有版本都是不好的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出第一个错误的版本，导致下面所有的错误。

你可以通过 bool isBadVersion(version) 的接口来判断版本号 version 是否在单元测试中出错。
实现一个函数来查找第一个错误的版本。您应该尽量减少对 API 的调用次数。
 */
public class LeetCode21 {

	public static void main(String[] args) {
		
	}

	//解法1 28ms   6.53% 
	public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int middle = start + (end - start)/2;
        while(true) {
        		if(middle == 1) {
        			if(isBadVersion(middle)) {
        				return 1;
        			}
        		}
        		if(middle == n) {
        			if(!isBadVersion(middle)) {
        				return 0;
        			}
        		}
        		boolean b1 = isBadVersion(middle - 1);
        		boolean b2 = isBadVersion(middle);
        		if(b2 && !b1) {
        			return middle;
        		}
        		if(b2 && b1) {
        			end = middle - 1;
        		}
        		if(!b2) {
        			start = middle + 1;
        		}
        		middle = start + (end - start)/2;
        }
    }
	
	
	public boolean isBadVersion(int version) {
		return true;
	}
}
