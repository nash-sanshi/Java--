package src.main.java.day10;

public class Ten14_EnumTest {
	public static void main(String[] args) {
	doOp (OpConstant.TURN_LEFT);
	doOp (OpConstant.TURN_RIGHT);
	doOp (OpConstant.SHOOT);
	}
	public static void doOp(OpConstant op) {
		//op�˴��ı������;�Ŀǰ��ѧ������������ֻ��Ϊ4�����ͣ�byte��short��int��char��1.7�İ汾ö�٣�String
		switch(op) {
		case TURN_LEFT:
		System.out.println("����ת");
		break;
		case TURN_RIGHT:
		System.out.println("����ת");
		break;
		case SHOOT:
		System.out.println("���");
		break;
		}
	}
}

enum OpConstant {
	TURN_LEFT,TURN_RIGHT,SHOOT
}