package src.main.java.day10;

import static src.main.java.day10.comment.Comment.AGE;
import static src.main.java.day10.comment.Comment.output;
//表示导入Comment类中的静态成员变量AGE以及静态方法output
//注意：使用import static时，要一直导入到类中的静态成员变量或静态方法

public class Ten16_StaticImportTest {
	public static void main(String[] args) {

		System.out.println(AGE);
		output();
	}
}
