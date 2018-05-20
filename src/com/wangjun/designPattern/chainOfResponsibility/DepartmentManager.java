package com.wangjun.designPattern.chainOfResponsibility;

public class DepartmentManager extends Handler {

	@Override
	public boolean handler(int fee) {
		if(fee <= 2000) {
			System.out.println("部门经理：审批通过。金额：" + fee);
			return true;
		}else {
			System.out.println("金额大于2000，部门经理无权审批，移交给总经理！");
			setSuccessor(new Manager());
			return successor.handler(fee);
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
