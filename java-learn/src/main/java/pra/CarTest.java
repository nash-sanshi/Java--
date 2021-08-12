package src.main.java.pra;

public class CarTest {
    public static void main(String[] args) {
        CarTest a = new CarTest();
        Car b = new Bmw();
        a.run(b);
        b.run();
    }

    public void run(Car car){
        car.run();
    }
}

class Car{
    public void run(){
        System.out.println("Car is running");
    }
}

class Bmw extends Car{
    public void run(){
        System.out.println("Bmw is running");
    }
}

class Qq extends Car{
    public void run(){
        System.out.println("Qq is running");
    }
}