package com.wangjun.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 罗马数字转整数
 * 字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class LeetCode74 {

	public static void main(String[] args) {
		System.out.println(romanToInt("IV"));
	}
	
	public static int romanToInt(String s) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for(int i = 0; i < s.length(); i++) {
			int num1 = map.get(s.charAt(i));
			int num2 = (i + 1) < s.length()? map.get(s.charAt(i + 1)): 0;
			if(num1 >= num2) {
				res += num1;
			}else {
				res += (num2 - num1);
				i++;
			}
		}
		return res;
    }

}
