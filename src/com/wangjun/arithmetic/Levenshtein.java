package com.wangjun.arithmetic;

/*
 * Levenshtein距离是一种计算两个字符串间的差异程度的字符串度量（string metric）。
 * 我们可以认为Levenshtein距离就是从一个字符串修改到另一个字符串时，
 * 其中编辑单个字符（比如修改、插入、删除）所需要的最少次数。
 */
public class Levenshtein {

	public static void main(String[] args) {
		Levenshtein levenshtein = new Levenshtein();
		System.out.println(levenshtein.disString("kitten", "sitting"));
	}
	
	// 使用递归
	// 参考：http://blog.sina.com.cn/s/blog_7d1968e20102x2rn.html
	public int disString(String str1, String str2){
	    int len1 = str1.length();
	    int len2 = str2.length();
	    if(len1 == 0 || len2 == 0){
	        return len1 > len2? len1 : len2;
	    }
	    
	    String str11 = str1.substring(0, len1 - 1);
	    String str22 = str2.substring(0, len2 - 1);
	    
	    int dis1 = disString(str11, str2) + 1;
	    int dis2 = disString(str1, str22) + 1;
	    int dis3 = disString(str11, str22);
	    
	    dis3 = str1.charAt(len1 - 1) == str2.charAt(len2 - 1)? dis3 : dis3 + 1;
	    
	    return min(dis1, dis2, dis3);
	    
	}
	public int min(int dis1, int dis2, int dis3){
	    if(dis1 > dis2){
	        if(dis2 > dis3){
	            return dis3;
	        }else{
	            return dis2;
	        }
	    }else{
	        if(dis1 > dis3){ 
	            return dis3;       
	        }else{
	            return dis1;
	        }
	    }
	}

}
