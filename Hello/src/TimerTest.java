import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {
		System.out.println("当前的时间为：" + new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 10);
		Date runDate = cal.getTime();
		
		MyTask mt = new MyTask();
		Timer timer = new Timer();
		timer.schedule(mt, runDate);
	}

}
class MyTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("任务执行了，时间为：" + new Date());
	}
	
}
