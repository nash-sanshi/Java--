package src.main.java.pra.old;

class ParentClass {
    private int parentX;
    public ParentClass() {
        setX(100);
    }
    public void setX(int x) {
        parentX = x;
    }
}

class ChildClass extends ParentClass{
    private int childX = 1;
    public ChildClass() {}

    public void setX(int x) {
        super.setX(x);
        childX = x;
        System.out.println("ChildX ±»¸³ÖµÎª " + x);
    }
    public void printX() {
        System.out.println("ChildX = " + childX);
    }

}

public class TryInitMain {
    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        cc.printX();
    }
}