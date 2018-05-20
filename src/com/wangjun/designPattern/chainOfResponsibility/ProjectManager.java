package com.wangjun.designPattern.chainOfResponsibility;

public class ProjectManager extends Handler {

	@Override
	public boolean handler(int fee) {
		if(fee <= 1000) {
			System.out.println("项目经理：审批通过。金额：" + fee);
			return true;
		}else {
			System.out.println("金额大于1000，项目经理无权审批，移交给部门经理！");
			setSuccessor(new DepartmentManager());
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
