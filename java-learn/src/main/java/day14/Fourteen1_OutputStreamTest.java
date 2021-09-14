package src.main.java.day14;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Fourteen1_OutputStreamTest {
//新建文件并写入字符串
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream(
				"D:/java项目/java-learn/src/main/java/day14/1.txt",true);
		//FileOutputStream的append为true的时候，写入是追加不会覆盖
		os.write("ssssssss".getBytes());
		os.close();
	}
}
