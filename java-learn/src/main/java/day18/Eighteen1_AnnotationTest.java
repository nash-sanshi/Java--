package src.main.java.day18;


import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("ALL")
public class Eighteen1_AnnotationTest {
    //@SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        @SuppressWarnings("rawtypes")
        //���ע�⣬����ע�⣬��ע��
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
    @Override//��дע��
    void test() {
        super.test();
    }
}
