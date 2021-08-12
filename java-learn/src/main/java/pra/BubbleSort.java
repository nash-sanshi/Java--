package src.main.java.pra;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int []a = {3,5,8,9,2,7,6,1};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        //for (int j : a) System.out.print(j);
    }

    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length -i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] =temp;
                }
            }
            System.out.println("µÚ"+ (i+1) +"´ÎÅÅÐò");
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k]);
            }
            System.out.println();
        }
    }
}
