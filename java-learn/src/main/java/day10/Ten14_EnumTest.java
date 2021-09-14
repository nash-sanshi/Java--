package src.main.java.day10;

public class Ten14_EnumTest {
	public static void main(String[] args) {
	doOp (OpConstant.TURN_LEFT);
	doOp (OpConstant.TURN_RIGHT);
	doOp (OpConstant.SHOOT);
	}
	public static void doOp(OpConstant op) {
		//op此处的变量类型就目前所学的内容来看，只能为4种类型：byte，short，int，char，1.7的版本枚举，String
		switch(op) {
		case TURN_LEFT:
		System.out.println("向左转");
		break;
		case TURN_RIGHT:
		System.out.println("向右转");
		break;
		case SHOOT:
		System.out.println("射击");
		break;
		}
	}
}

enum OpConstant {
	TURN_LEFT,TURN_RIGHT,SHOOT
}