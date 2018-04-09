package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class LeetCode6 {

	public static void main(String[] args) {
		
		String[] words =  {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> list = new Leetcode1().topKFrequent(words, 2);
		System.out.println(list.toString());
		
	}
	
	public List<String> topKFrequent(String[] words, int k) {
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < words.length; i++){
			String word = words[i];
			if(map.keySet().contains(word)){
				map.replace(word, map.get(word) + 1);
			}else{
				map.put(word, 1);
			}
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>();
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			list.add(entry);
		}
		
		//冒泡排序
		for (int i = 0; i < list.size() - 1 && i < k; i++) {
			for(int j = i + 1; j < list.size(); j++){
				Map.Entry<String, Integer> entryI = list.get(i);
				Map.Entry<String, Integer> entryJ = list.get(j);
				if(entryI.getValue() < entryJ.getValue()){
					Map.Entry<String, Integer> tem = entryI;
					list.set(i, entryJ);
					list.set(j, tem);
				}else if(entryI.getValue() > entryJ.getValue()){
					
				}else if(entryI.getKey().compareTo(entryJ.getKey()) > 0){
					Map.Entry<String, Integer> tem = entryI;
					list.set(i, entryJ);
					list.set(j, tem);
				}
			}
		}
		
		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(list.get(i).getKey());
		}
		return result;
    }

}
