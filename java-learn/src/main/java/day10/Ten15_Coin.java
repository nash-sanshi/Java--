package src.main.java.day10;

public enum Ten15_Coin {
    penny("hello"),nickel("world"),dime("welcome");

    private final String s;

	public String getS() {
		return s;
	}

	Ten15_Coin(String s) {
		this.s = s;
	}

	public static void main(String[] args) {
		System.out.println(Ten15_Coin.dime.getS());
	}
}

