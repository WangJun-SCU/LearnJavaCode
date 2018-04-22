public class AccountAddRemove {
	public static void main(String[] args) {
		Serve s = new Serve();
		Thread t1 = new Thread(new ThreadA(s));
		Thread t2 = new Thread(new ThreadB(s));
		t1.start();
		t2.start();
	}
}

class Serve {
	private int count = 0;
	private boolean hasCount = false;

	public synchronized void addCount(int addCount) {
		try {
			if (hasCount) {
				wait();
				System.out.println("add阻塞");
			} else {
				this.count += addCount;
				hasCount = true;
				notifyAll();
				System.out.println("存钱，余额：" + this.count);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void removeCount(int removeCount) {
		try {
			if (hasCount) {
				this.count -= removeCount;
				hasCount = false;
				notifyAll();
				System.out.println("取钱，余额：" + this.count);
			} else {
				wait();
				System.out.println("remove阻塞");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class ThreadA implements Runnable {

	private Serve s;

	public ThreadA(Serve s) {
		this.s = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("add" + i);
			s.addCount(100);
		}
	}
}

class ThreadB implements Runnable {

	private Serve s;

	public ThreadB(Serve s) {
		this.s = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("remove" + i);
			s.removeCount(100);
		}
	}
}