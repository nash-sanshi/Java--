package src.main.java.day17;

import java.util.Scanner;

/**
 * 对QQ号进行验证
 * 5-15位，不能以0开头，必须是数字
 */
public class Seventeen10_RegexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入QQ号码：");
        String qq = sc.nextLine();
        boolean flag = checkQQ(qq);
        System.out.println(flag);

        //正则表达式，第一位1-9，第二位往后0-9，必须4-14位
        boolean matches = qq.matches("[1-9][0-9]{4,14}");
        System.out.println(matches);
    }

    public static boolean checkQQ(String qq) {
        boolean flag = true;
        //判断长度
        if (qq.length() >= 5 && qq.length() <= 15) {
            //0不能开头
            if (!qq.startsWith("0")) {
                //全数字
                char[] chs = qq.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char ch = chs[i];
                    if (!(ch >= '0' && ch <= '9')) {
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
            }
        } else
            flag = false;
        return flag;
    }
}

