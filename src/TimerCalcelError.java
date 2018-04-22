import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCalcelError {

	public static void main(String[] args) {
		int i = 0;
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		while(true) {
			i++;
			Timer timer = new Timer();
			MyTask1 m = new MyTask1(i);
			timer.schedule(m, date);
			timer.cancel();
		}
	}

}
class MyTask1 extends TimerTask {
	private int i;
	MyTask1(int i) {
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println(i + "次没有被cancel！");
	}
}