package com.wangjun.thread;

public class LockOptimizeTest {
	
	class Singleton {
		private Singleton instance;
		
		private Singleton() {
		}
		
		public Singleton getInstance() {
			try {
				Thread.sleep(1000);  //do something
				synchronized(this) {
					if(null == instance)
						instance = new Singleton();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return instance;
		}
	}
}
