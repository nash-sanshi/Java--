package src.main.java.pra;

import javax.swing.*;
import java.awt.*;

public class Pra8_DrawStar {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setSize(500, 500);
        MyPanel p = new MyPanel();
        jFrame.add(p);
        jFrame.setVisible(true);
    }

    public static class MyPanel extends Panel {
        @Override
        public void paint(Graphics g) {
            g.setColor(Color.WHITE);
            for (int i = 0; i < 1000; i++) {
                g.drawString("*",(int) (Math.random()*500),(int) (Math.random()*500));
            }
        }



    }

}