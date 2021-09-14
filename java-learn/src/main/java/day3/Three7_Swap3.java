package src.main.java.day3;

public class Three7_Swap3
{
		public static void swap3(int[] i)
		{
			int temp = i[0];
			i[0] = i[1];
			i[1] = temp;
		}
		
		public static void main(String [] args)
		{
			int[] i = {1,2};
			swap3(i);
			System.out.println(i[0]);
			System.out.println(i[1]);
			for (int j = 0; j < i.length; j++) {
				System.out.println(i[j]);
			}
		}
} 