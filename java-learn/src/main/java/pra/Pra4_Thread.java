package src.main.java.pra;

public class Pra4_Thread {
    public static void main(String[] args) {
        Example e = new Example();
        Thread1 t1 = new Thread1(e);
        Thread2 t2 = new Thread2(e);
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{
    Example example1;

    public Thread1(Example example1) {
        this.example1 = example1;
    }

    public void run(){
        this.example1.run1();
    }
}

class Thread2 extends Thread{
    Example example2;

    public Thread2(Example example2) {
        this.example2 = example2;
    }

    public void run(){
        this.example2.run2();
    }
}

class Example{
    public synchronized void run1(){
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello"+ i);
        }
    }

    public synchronized void run2(){
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("world"+ i);
        }
    }
}
