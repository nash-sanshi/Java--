package src.main.java.pra;

public class Pra5_Crease {
    public static void main(String[] args) {
        Sample s = new Sample();
        Thread t1 = new IncreaseThread(s);
        Thread t2 = new DecreaseThread(s);
        Thread t3 = new IncreaseThread(s);
        Thread t4 = new DecreaseThread(s);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class IncreaseThread extends Thread{
    private final Sample s;

    public IncreaseThread(Sample s) { this.s=s;}

    public void run(){
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long)(Math.random()*1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            s.increase();
        }
    }
}

class DecreaseThread extends Thread{
    private final Sample s;

    public DecreaseThread(Sample s) { this.s=s;}

    public void run(){
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep((long)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.decrease();
        }
    }
}

class Sample{
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
