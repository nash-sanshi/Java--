package src.main.java.day13;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Thirteen1_TestButton {
    public static void main(String[] args) {
        Frame f = new Frame("TestButton");
        Button b = new Button("Press me");
        //增加按钮事件处理器
        b.addActionListener(new MyButtonListener());
        //增加窗口事件处理器
        f.addWindowListener(new MyWindowListener(f));
        f.add(b,BorderLayout.CENTER);
        f.setSize(200,200);
        f.setVisible(true);
    }
}

class MyButtonListener implements ActionListener {
    @Override//重写
    public void actionPerformed(ActionEvent e) {
        //String lable = e.getActionCommand();
        System.out.println(e.getActionCommand());
    }
}

class MyWindowListener implements WindowListener {
    Frame f;

    public MyWindowListener(Frame f) {
        this.f = f;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("打开");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("关闭中");
        //System.exit(0);
        this.f.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("已关闭");
        //System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }
}