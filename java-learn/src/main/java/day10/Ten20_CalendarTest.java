package src.main.java.day10;

import java.util.Calendar;

public class Ten20_CalendarTest {
	public static void main(String[] args) {

		show(Calendar.getInstance());
	}
	
	public static void show(Calendar c) {
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH)+1;
	int day = c.get(Calendar.DAY_OF_MONTH);
	System.out.println(year + "Äê" + month + "ÔÂ" + day + "ÈÕ");
	}
}

