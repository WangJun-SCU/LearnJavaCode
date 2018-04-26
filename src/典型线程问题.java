/**
 * 假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小,
 * 所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
 * @author wangjun
 *
 */
public class 典型线程问题 {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1(new MyThread() {
			@Override
			public void runSomething() {
				for (int i = 0; i < 100; i++) {
					System.out.println("统计A盘大小" + i);
				}
			}
		});
		Thread1 t2 = new Thread1(new MyThread() {
			@Override
			public void runSomething() {
				for (int i = 0; i < 100; i++) {
					System.out.println("统计B盘大小" + i);
				}
			}
		});
		Thread1 t3 = new Thread1(new MyThread() {
			@Override
			public void runSomething() {
				for (int i = 0; i < 100; i++) {
					System.out.println("统计C盘大小" + i);
				}
			}
		});
		Thread1 t4 = new Thread1(new MyThread() {
			@Override
			public void runSomething() {
				for (int i = 0; i < 100; i++) {
					System.out.println("统计D盘大小" + i);
				}
			}
		});
		Thread1 t = new Thread1(new MyThread() {
			@Override
			public void runSomething() {
				try {
					for (int i = 0; i < 100; i++) {
						if(i == 20) {
							t1.start();
							t2.start();
							t3.start();
							t4.start();
							t1.join();
							t2.join();
							t3.join();
							t4.join();
						}
						System.out.println("统计线程" + i);
					}
				} catch (Exception e) {
				}
			}
		});
		t.start();
	}
}
class Thread1 extends Thread {
	MyThread myThread;
	public Thread1(MyThread myThread) {
		this.myThread  = myThread;
	}
	//用匿名内部类结合命令模式实现动态传入run的动作
	@Override
	public void run() {
		doSomething(myThread);
	}
	private void doSomething(MyThread myThread) {
		myThread.runSomething();
	}
}
interface MyThread {
	void runSomething();
}