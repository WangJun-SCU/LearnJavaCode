package con.wangjun.designPattern.observer;

public interface Subject {
	public void addFans(Observer o);  // 添加粉丝
	public void removeFans(Observer o);  // 移除粉丝
	public void notifyFans(String str);  // 通知粉丝
}
