import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DrawDeposit {

	public static void main(String[] args) {
		Account acct = new Account();
		new DrawThread(acct).start();
		new DepositThread(acct).start();
	}

}
class DrawThread extends Thread {
	private Account acct;
	public DrawThread(Account acct) {
		this.acct = acct;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				acct.Draw(1000.0);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class DepositThread extends Thread {
	private Account acct;
	public DepositThread(Account acct) {
		this.acct = acct;
	}
	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				acct.deposit(1000.0);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class Account {
	private double balance;
	private boolean flag = false;//有没有存过钱
	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	//取钱
	public void Draw(Double drawAmount) throws InterruptedException{
		lock.lock();
		try {
			if(!flag) {
				cond.await();
			}else {
				if(balance >= drawAmount) {
					balance -= drawAmount;
				}else {
					System.out.println("余额不足！");
				}
				System.out.println("取钱：余额：" + balance);
				flag = false;
				cond.signalAll();
			}
			lock.unlock();
		} finally {
		}
	}
	//存钱
	public void deposit(double depositAmount) throws InterruptedException{
		lock.lock();
		try {
			if(flag) {
				cond.await();
			}else {
				balance += depositAmount;
				flag = true;
				cond.signalAll();
				System.out.println("存钱：余额：" + balance);
			}
		} finally {
			lock.unlock();
		}
		
	}
}
