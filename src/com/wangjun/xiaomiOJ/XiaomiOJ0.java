package com.wangjun.xiaomiOJ;
/**
 * @author wangjun
 * @date 2018-12-27
 * @version 1.0
 * 
 * 送分体验题
 * A + B
 */
public class XiaomiOJ0 {
	
	public static void main(String[] args) {
		System.out.println(solution("1 22"));
	}

	/**
	* 已引入：
	* java.util.*
	* 要使用其他 jar 包请使用完整路径，如：
	* java.util.List<java.util.List<Integer>> list = new java.util.ArrayList<java.util.List<Integer>>(100);
	* @param  line 为单行测试数据
	* @return 处理后的结果
	*/
	private static String solution(String line) {
	    // please write your code here
	    // 在此处理单行数据
	    String[] array = line.split(" ");
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        int a = Integer.parseInt(array[i]);
	        count = count + a;
	    }
	    String result = Integer.toString(count);
	    // 返回处理后的结果
	    return result;
	    // return ans;
	}
}

