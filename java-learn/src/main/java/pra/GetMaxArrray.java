package src.main.java.pra;

public class GetMaxArrray {
    public static void main(String[] args) {
        int[] a = {1,6,9,4,3,7};
        System.out.println(GetMaxArrray.getMax(a));
    }

    public static int getMax(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max=array[i];
        }return max;
    }
}
