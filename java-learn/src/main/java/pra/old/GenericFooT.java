package src.main.java.pra.old;

public class GenericFooT<T> {
    private T foo;

    public T getFoo() {
        return foo;
    }

    public void setFoo(T foo) {
        this.foo = foo;
    }

    public static void main(String[] args) {
        GenericFooT<Boolean> a = new GenericFooT<>();
        GenericFooT<Integer> b = new GenericFooT<>();
        a.setFoo(false);
        b.setFoo(3);
        System.out.println(a.getFoo());
        System.out.println(b.getFoo());
    }
}
