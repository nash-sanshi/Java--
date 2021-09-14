package src.main.java.day10;

public class Ten13_ColorTest {

	public static void main(String[] args) {
		Ten12_Color myTen13Color = Ten12_Color.Blue;
		System.out.println(myTen13Color);
		System.out.println("---------------");
		for (Ten12_Color c : Ten12_Color.values()) {
			System.out.println(c);
		}
	}
}
