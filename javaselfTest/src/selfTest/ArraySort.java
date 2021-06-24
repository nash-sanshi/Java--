package selfTest;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
		// 排序前:
		System.out.println(Arrays.toString(ns));

		/*
        //先把数组全部变成负数
        for (int i = 0; i < ns.length; i++) {
            ns[i] = -ns[i];
        }
        //负数排序肯定是反的
        Arrays.sort(ns);
        //再把数组全部变成正数，思路清奇
        for (int i = 0; i < ns.length; i++) {
            ns[i] = -ns[i];
        }
		 */

		for(int i=0;i<ns.length-1;i++){
			for(int j=0;j<ns.length-i-1;j++){
				if(ns[j] < ns[j+1]){
					int tmp = ns[j];
					ns[j] = ns[j+1];
					ns[j+1] = tmp;
				}
			}
		}
		// 排序后:
		System.out.println(Arrays.toString(ns));
		if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
			System.out.println("测试成功");
		} else {
			System.out.println("测试失败");
		}
	}
}
