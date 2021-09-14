package src.main.java.day18;


import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("ALL")
public class Eighteen1_AnnotationTest {
    //@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        //语句注解，方法注解，类注解
        List list = new ArrayList();
    }
}

@Eighteen2_HelloAnnotation
class A {
    @Eighteen2_HelloAnnotation
    void test() {
        @Eighteen2_HelloAnnotation
                List t = new ArrayList();
    }
}

class B extends A {
    @Override//重写注解
    void test() {
        super.test();
    }
}
