import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小,
 * 所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
 * 1.如果统计的方法一样
 * @author wangjun
 *
 */
public class StatisticsThread {

	public static void main(String[] args) {
		Panzi p1 = new Panzi(10);
		Panzi p2 = new Panzi(20);
		Panzi p3 = new Panzi(30);
		Panzi p4 = new Panzi(20);
		TongjiThread t1 = new TongjiThread(p1);
		TongjiThread t2 = new TongjiThread(p2);
		TongjiThread t3 = new TongjiThread(p3);
		TongjiThread t4 = new TongjiThread(p4);
		FutureTask<Integer> f1 = new FutureTask<Integer>(t1);
		FutureTask<Integer> f2 = new FutureTask<Integer>(t2);
		FutureTask<Integer> f3 = new FutureTask<Integer>(t3);
		FutureTask<Integer> f4 = new FutureTask<Integer>(t4);
		Thread t11 = new Thread(f1);
		Thread t12 = new Thread(f2);
		Thread t13 = new Thread(f3);
		Thread t14 = new Thread(f4);
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t11.join();
					t12.join();
					t13.join();
					t14.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("汇总盘子大小:");
				try {
					System.out.println("盘子1的大小为" + f1.get());
					System.out.println("盘子2的大小为" + f2.get());
					System.out.println("盘子3的大小为" + f3.get());
					System.out.println("盘子4的大小为" + f4.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		});
		t5.start();
	}
}

class TongjiThread implements Callable<Integer> {
	Panzi panzi;
	public TongjiThread(Panzi panzi) {
		this.panzi = panzi;
	}

	@Override
	public Integer call() throws Exception {
		//统计盘子的大小
		return sizeOfPanzi(panzi);
	}
	private Integer sizeOfPanzi(Panzi panzi) {
		for (int i = 0; i < 10000; i++) {
			System.out.println(Thread.currentThread().getName() + ":" +i);
		}
		return panzi.getSize();
	}
}

/**
 * 盘子类，保存盘子的大小
 * @author wangjun
 *
 */
class Panzi {
	int size;
	public Panzi(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
}
