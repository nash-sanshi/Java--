package src.main.java.day17;

import java.util.Scanner;

/**
 * ��QQ�Ž�����֤
 * 5-15λ��������0��ͷ������������
 */
public class Seventeen10_RegexTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������QQ���룺");
        String qq = sc.nextLine();
        boolean flag = checkQQ(qq);
        System.out.println(flag);

        //������ʽ����һλ1-9���ڶ�λ����0-9������4-14λ
        boolean matches = qq.matches("[1-9][0-9]{4,14}");
        System.out.println(matches);
    }

    public static boolean checkQQ(String qq) {
        boolean flag = true;
        //�жϳ���
        if (qq.length() >= 5 && qq.length() <= 15) {
            //0���ܿ�ͷ
            if (!qq.startsWith("0")) {
                //ȫ����
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

