package con.wangjun.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		VSubject vs = new VSubject();  // 大V的实例  
		List<FansObserver> fans = new ArrayList<>();  // 存储所有粉丝
		
		for(int i = 0; i < 5; i++) {
			FansObserver f = new FansObserver("name" + (i + 1));
			fans.add(f);
			vs.addFans(f);
		}
		// 本次发微博，5个粉丝都收到推送
		vs.publish("我的女朋友真好看！");
		// 居然秀恩爱，前2个粉丝，看不下去了，取关！
		for(int i = 0; i < 2; i++) {
			vs.removeFans(fans.get(i));
		}
		
		// 这次发微博，那两个取关的人就看不到了
		vs.publish("我要送所有粉丝一部iPhone X");
	}
}
