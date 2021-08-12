package src.main.java.day2;

public class ForTest2 {
	/*
	*****
	****
	***
	**
	*
	*/
	public static void main(String[] args) {
	for (int x = 1;x <= 5;x ++) {
		for (int y = x;y <= 5;y++) {
			System.out.print("*");//print打印不换行，println打印换行
		}
		System.out.println();
	}
	}
}