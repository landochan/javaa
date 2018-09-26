import java.util.Calendar;
import java.util.Date;
public class tester {
	public static void main(String[] args) {
		Calendar d = Calendar.getInstance();
		d.set(2020,4,4,13,20,10);
		long day1 = d.getTimeInMillis();
		day1 += 1000*60*60;
		System.out.println("time in millis " + day1);
		d.setTimeInMillis(day1);
		System.out.println("add new hour " + d.getTime());
		d.add(d.DATE, 10);
		System.out.println("add ten days " + d.getTime());
		d.roll(d.DATE, 1000);
		System.out.println("roll one thousanf times "+ d.getTime());
		d.set(d.DATE,15);
		System.out.println("time has set to "+d.getTime());
	}
}
		
