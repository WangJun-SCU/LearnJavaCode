package con.wangjun.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class VSubject implements Subject {
	
	List<Observer> list = new ArrayList<>();
	
	// 发布微博
	public void publish(String str) {
		System.out.println("大V发布微博：" + str);
		// 通知所有粉丝
		notifyFans(str);
	}

	@Override
	public void addFans(Observer o) {
		list.add(o);
	}

	@Override
	public void removeFans(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyFans(String str) {
		for(int i = 0; i < list.size(); i++) {
			list.get(i).update(str);
		}
	}

}
