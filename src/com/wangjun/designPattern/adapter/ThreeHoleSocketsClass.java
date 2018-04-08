package com.wangjun.designPattern.adapter;

/**
 * 
 * @author wangjun 
 * @email  scuwangjun@hotmail.com
 * @time   2018年4月1日 下午5:08:53 
 * 
 */

public class ThreeHoleSocketsClass implements ThreeHoleSockets {

	@Override
	public int holeCount() {
		return 3;
	}

}
