package com.wangjun.designPattern.chainOfResponsibility;

public abstract class Handler {
	protected Handler successor;
	
	public abstract boolean handler(int fee);
	
	public abstract void setSuccessor(Handler successor);
	
	public abstract Handler getSuccessot();
}
