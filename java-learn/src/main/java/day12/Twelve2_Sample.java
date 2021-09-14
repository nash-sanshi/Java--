package src.main.java.day12;

public class Twelve2_Sample {
    private int number;

    public synchronized void increase() {
        while (number != 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(number);
        notify();
    }

    public synchronized void decrease() {
        while (number == 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(number);
        notify();
    }
}
