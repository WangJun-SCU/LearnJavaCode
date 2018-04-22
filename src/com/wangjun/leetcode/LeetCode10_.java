package com.wangjun.leetcode;

/*
题目：第K个语法符号
在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
例子:
输入: N = 1, K = 1
输出: 0
输入: N = 2, K = 1
输出: 0
输入: N = 2, K = 2
输出: 1
输入: N = 4, K = 5
输出: 1
解释:
第一行: 0
第二行: 01
第三行: 0110
第四行: 01101001
 */
public class LeetCode10_ {

	public static void main(String[] args) {
			System.out.println(new LeetCode10_().kthGrammar2(30, 434991989));
	}
	
	//  解法1，大数内存不足了
	public int kthGrammar(int N, int K) {
        StringBuilder sb = new StringBuilder("0");
        for(int i = 0; i < N - 1; i++){
            StringBuilder tem = new StringBuilder();
            for(int j = 0; j < sb.length(); j++){
                if(sb.charAt(j) == '0'){
                    tem.append("01");
                }else if(sb.charAt(j) == '1'){
                    tem.append("10");
                }
            }
            sb = tem;
        }
        return Integer.parseInt(String.valueOf(sb.charAt(K - 1)));
    }
	// 解法2,神奇，没看懂...
	public int kthGrammar2(int N, int K) {
       return Integer.bitCount(K - 1) & 1;
    }

}