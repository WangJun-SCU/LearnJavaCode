package com.wangjun.leetcode;
/*
 * 动态规划经典算法题！
 * 
 * 1. 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

2. 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LeetCode72 {

	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
		
		int[] nums2 = {-2,1,-3,4,-1,2,1,-5,4};
		int[] res = maxSubArray2(nums2);
		for(int i = res[0]; i <= res[1]; i++) {
			System.out.print(nums2[i] + " ");
		}
	}
	
	/*
	 * 典型的动态规划问题，经过分析得到状态转移方程：状态转移方程：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
	 */
	public static int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		int sum1 = nums[0], sum2 = nums[1] > nums[0]? nums[1]: nums[0];
		for(int i = 2; i < nums.length; i++) {
			int tem = sum1;
			sum1 = sum2;
			if((nums[i] + tem) > sum2) {
				sum2 = nums[i] + tem;
			}
		}
		return sum2;
    }
	/*
	 * 求最大子序列(Kadane算法)
	 * 1.先将问题进行拆分,指定数组中某一个元素A[i]作为最大子数列的末尾元素时,能找到的最大子数列的求和值是多少
	 * 2.这样就会发现，A[i]作为末尾元素时能找到的最大子数列max_i肯定为A[i]或者以A[i-1]作为末尾元素时找到的最大
	 * 子数列max_i-1加上A[i]【对应步骤1】
	 * 3.所以我们只需要从头到尾遍历数组，依次计算出每一个位置的A[i]作为末尾元素时，能找到的最大子数列max_i
	 * 然后通过另外一个变量记录下次过程中找到的最大的那个序列值【对应步骤2】
	 * 
	 */
	public static int maxSubArray(int[] nums) {
		if(nums.length == 0) return 0;
		int max = nums[0], maxCur = nums[0];
		for(int i = 1; i < nums.length; i++) {
			maxCur = Math.max(maxCur + nums[i], nums[i]);//步骤1
			max = Math.max(max, maxCur);//步骤2
		}
		return max;
    }
	
	/*
	 * 求最大子序列并返回子序列的下标
	 */
	public static int[] maxSubArray2(int[] nums) {
		int[] res = {0, 0};
		if(nums.length == 0) return res;
		int max = nums[0], maxCur = nums[0];
		int left = 0, right = 0, leftCur = 0, rightCur = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] >= maxCur + nums[i]) {
				leftCur = i;
				rightCur = i;
				maxCur = nums[i];
			}else {
				rightCur = i;
				maxCur = maxCur + nums[i];
			}
			if(max < maxCur) {
				max = maxCur;
				left = leftCur;
				right = rightCur;
			}
		}
		res[0] = left;
		res[1] = right;
		return res;
	}

}
