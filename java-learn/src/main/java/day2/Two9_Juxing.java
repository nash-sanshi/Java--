package src.main.java.day2;

public class Two9_Juxing {
	/*
	���󣺶���һ�������εĹ���
		1.û�н����������void
		2.��2��������int�������к���
	*/
	public static void draw(int a,int b) {
		for(int x = 0;x < a; x++) {
			for(int y = 0;y < b; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		draw(2,2);
		System.out.println();
		draw(5,5);
	}
}