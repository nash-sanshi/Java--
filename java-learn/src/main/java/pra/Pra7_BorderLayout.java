package src.main.java.pra;

import javax.swing.*;
import java.awt.*;

public class Pra7_BorderLayout {
    public static void main(String[] args) {
        Pra7_BorderLayout pra7_borderLayout = new Pra7_BorderLayout();
        pra7_borderLayout.go();
    }

    public void go(){
        JFrame jFrame = new JFrame("窗口的默认布局为BorderLayout");
        jFrame.add(new Button("b1"), BorderLayout.NORTH);
        jFrame.add(new Button("b2"), BorderLayout.WEST);
        jFrame.add(new Button("b3"), BorderLayout.SOUTH);
        jFrame.add(new Button("b4"), BorderLayout.EAST);
        //jFrame.pack();
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
    }
}
