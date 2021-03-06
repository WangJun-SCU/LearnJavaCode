package com.wangjun.arithmetic;
/** 
 * 实现数组转链表
 * 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月6日 上午11:32:39 
 */
public class ArrayToChain {

	public static void main(String[] args) {
		//测试
		int[] arr = {1,2,3,4,5,6};
		ArrayToChain arrayToChain = new ArrayToChain();
		ChainType result = arrayToChain.toChain(arr);
		arrayToChain.printChain(result);
	}
	
	/*
	 * 方法实现
	 */
	public ChainType toChain(int[] arr) {
		ChainType head = null;
		ChainType index = null;
		for(int i = 0; i < arr.length; i++) {
			ChainType temChain = new ChainType(arr[i]);
			ChainType temIndex = index; // 存储上一个节点
			index = temChain; //指针指向当前节点
			if(i == 0) {
				head = index;
			}else {
				temIndex.next = temChain; //使上一个节点指向当前节点
			}
		}
		return head;
	}
	
	/*
	 * 打印链表
	 */
	public void printChain(ChainType chain) {
		while(null != chain) {
			System.out.println(chain.num);
			chain = chain.next;
		}
	}

}
/*
 * 链表结构体
 */
class ChainType {
	int num;
	ChainType next;
	ChainType(int num){
		this.num = num;
	}
}


