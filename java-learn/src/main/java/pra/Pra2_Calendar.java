package src.main.java.pra;

import java.util.Calendar;

public class Pra2_Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR)+"��"+
                (c.get(Calendar.MONTH)+1)+"��"+
                c.get(Calendar.DAY_OF_MONTH)+"��");
    }

}
