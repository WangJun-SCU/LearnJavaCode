public class Test {

	public static void main(String[] args) {
		Thread t = new Thread(() ->  {
			System.out.println("线程：" + Thread.currentThread().getName());
		});
		t.start();
	}
}
