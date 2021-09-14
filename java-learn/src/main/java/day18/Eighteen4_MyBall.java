package src.main.java.day18;

import javax.swing.*;
import java.awt.*;

public class Eighteen4_MyBall {
    public static void main(String[] args) {
        JFrame w = new JFrame();
        w.setSize(300,400);
        MyPanel1 mp = new MyPanel1();
        w.add(mp);
        Thread t = new Thread(mp);
        t.start();
        w.setVisible(true);
    }
}

class MyPanel1 extends Panel implements Runnable {
    int x = 30;
    int y = 30;
    int att = 0;//0表示右下，1左下，2左上，3右上

    @Override
    public void paint(Graphics g) {
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            //定义飞行姿态
            if (att == 0){
                x++;
                y++;
            }
            if (att == 1){
                x--;
                y++;
            }
            if (att == 2){
                x--;
                y--;
            }
            if (att == 3){
                x++;
                y--;
            }
            //改变飞行姿态
            if (x > 263) {
                if (att == 0)
                    att = 1;
                else
                    att = 2;
            }
            if (y > 341){
                if (att == 1)
                    att = 2;
                else
                    att = 3;
            }
            if (x <0){
                if (att == 2)
                    att = 3;
                else
                    att = 0;
            }
            if (y <0){
                if (att == 3)
                    att = 0;
                else
                    att = 1;
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}