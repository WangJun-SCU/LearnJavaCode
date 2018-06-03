import java.util.concurrent.atomic.AtomicInteger;

public class AutomicDemo {
	public static int k = 0;
	static AtomicInteger i = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {

		for (int m = 0; m < 10; m++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int p = 0; p < 4000; p++) {
						System.out.println("i：" + i.get());
						i.getAndIncrement();
						System.out.println("k: " + k);
						k++;
					}
				}
			});
			t.start();
			t.join();
		}
		System.out.println("最终i： --------------" + i);
		System.out.println("最终k: --------------" + k);
	}
}