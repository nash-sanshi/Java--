package src.main.java.day19;

import java.lang.reflect.Array;

public class Nineteen5_ArrayTest2 {
    public static void main(String[] args) {
        //���ɳ���Ϊ3��һά����
        int[] dims = new int[]{5, 10, 15};
        //���ɳ�5����10����15��ά����array
        Object array = Array.newInstance(Integer.TYPE, dims);
        //��ȡ����3�Ķ�ά����arrayObj
        Object arrayObj = Array.get(array, 3);
        //Class<?> classType = arrayObj.getClass().getComponentType();
        //��ȡ����5��һά����arrayObject
        Object arrayObject = Array.get(arrayObj, 5);
        //����һά��������10��ֵΪ37
        Array.setInt(arrayObject, 10, 37);
        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
    }
}
