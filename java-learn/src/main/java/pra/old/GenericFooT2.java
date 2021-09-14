package src.main.java.pra.old;

public class GenericFooT2<T1,T2> {
    private T1 t1;
    private T2 t2;

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }

    public static void main(String[] args) {
        GenericFooT2<Boolean,Integer> f = new GenericFooT2<>();
        f.setT1(false);
        f.setT2(3);
        System.out.println(f.getT1());
        System.out.println(f.getT2());
    }
}
