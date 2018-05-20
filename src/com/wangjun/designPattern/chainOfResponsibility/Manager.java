package com.wangjun.designPattern.chainOfResponsibility;

public class Manager extends Handler {

	@Override
	public boolean handler(int fee) {
		if(fee <= 10000) {
			System.out.println("总经理：审批通过。金额：" + fee);
			return true;
		}else {
			System.out.println("金额大于10000，审批不通过！申请金额：" + fee);
			return false;
		}
	}

	@Override
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	@Override
	public Handler getSuccessot() {
		return successor;
	}

}
