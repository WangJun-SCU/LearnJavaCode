package com.wangjun.designPattern.chainOfResponsibility;

public class Client {

	public static void main(String[] args) {
		// 测试申请费用列表
		int[] arr = {500, 1500, 2500, 29000}; 
		
		// 将申请提交给的项目经理
		ProjectManager pm = new ProjectManager();
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("第" + (i+1) + "笔费用");
			if(pm.handler(arr[i])) {
				System.out.println("申请经费成功！");
			}else {
				System.out.print("申请经费失败！");
			}
			System.out.println();
		}
	}

}
