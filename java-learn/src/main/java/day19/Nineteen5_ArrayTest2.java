package src.main.java.day19;

import java.lang.reflect.Array;

public class Nineteen5_ArrayTest2 {
    public static void main(String[] args) {
        //生成长度为3的一维数组
        int[] dims = new int[]{5, 10, 15};
        //生成长5，宽10，高15三维数组array
        Object array = Array.newInstance(Integer.TYPE, dims);
        //获取索引3的二维数组arrayObj
        Object arrayObj = Array.get(array, 3);
        //Class<?> classType = arrayObj.getClass().getComponentType();
        //获取索引5的一维数组arrayObject
        Object arrayObject = Array.get(arrayObj, 5);
        //设置一维数组索引10的值为37
        Array.setInt(arrayObject, 10, 37);
        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
    }
}
