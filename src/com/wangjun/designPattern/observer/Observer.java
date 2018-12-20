package com.wangjun.designPattern.observer;

public interface Observer {
	// 当被观察者调用notifyFans发通知，update方法会被回调
	public void update(String str);
}
