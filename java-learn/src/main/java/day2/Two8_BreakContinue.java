package src.main.java.day2;

public class Two8_BreakContinue {
	public static void main(String[] args) {
		for (int i = 0;i < 3;i++) {
			if (i == 1) {
				break;
			}
			for (int j = 0;j <= i;++j) {
				if (j == 1) {
					continue;
				}
				System.out.println("j=" + j);
			}
			System.out.println("i=" + i);
		}
	}
}

