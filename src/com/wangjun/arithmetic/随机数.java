package com.wangjun.arithmetic;

public class 随机数 {
	public static void main(String[] args) {
		int n = (int)(Math.random() * 10);
		// [10,100)
		int n2 = (int) (Math.random() * 90 + 10);
		System.out.println(n2);
		
		//一个数组里保存了几个城市的城市名，随机输出数组中的一个元素
		String[] citys = {"beijing","nanjing","shanghai","guangzhou","tianjin","chengdu"};
		int x = (int)(Math.random() * 6);
		System.out.println(citys[x]);
		
		//方法2 使用时间戳
		int x2 = (int) (System.currentTimeMillis() % 6);
		System.out.println(citys[x2]);
		
		//方法3 更精确的时间戳
		int x3 = (int) (System.nanoTime() % 6);
		System.out.println(citys[x3]);
		
		String[] arr = {"石头","剪刀","布"};
	}
}
