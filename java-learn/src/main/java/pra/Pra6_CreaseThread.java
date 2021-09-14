package src.main.java.pra;

public class Pra6_CreaseThread {
    public static void main(String[] args) {
        Sample sample = new Sample();
        Thread t1 = new IncreaseThread(sample);
        Thread t2 = new DecreaseThread(sample);
        t1.start();
        t2.start();
    }

    public static class IncreaseThread extends Thread{
        private Sample s;

        public IncreaseThread(Sample s) {
            this.s = s;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s.increase();
            }
        }
    }

    public static class DecreaseThread extends Thread{
        private Sample s;

        public DecreaseThread(Sample s) {
            this.s = s;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s.decrease();
            }
        }
    }

    public static class Sample{
        private int numble;

        public synchronized void increase(){
            while (numble != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numble++;
            System.out.println(numble);
            notify();
        }

        public synchronized void decrease(){
            while (numble == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numble--;
            System.out.println(numble);
            notify();
        }

    }
}