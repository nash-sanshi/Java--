package src.main.java.pra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Pra1_ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{8,2,3,4,5,6};
        String[] srr = new String[]{"aaa", "bbb", "ccc"};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(srr));
        //数组转集合
        System.out.println(Arrays.asList(srr));

        Collection<String> collections = new ArrayList<>();
        collections.add("aaa");
        collections.add("bbb");
        collections.add("ccc");
        //集合转数组
        String[] ssr = collections.toArray(new String[0]);
        System.out.println(Arrays.toString(ssr));
    }
}
