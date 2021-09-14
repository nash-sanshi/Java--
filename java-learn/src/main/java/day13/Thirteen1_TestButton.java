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
        //���Ӱ�ť�¼�������
        b.addActionListener(new MyButtonListener());
        //���Ӵ����¼�������
        f.addWindowListener(new MyWindowListener(f));
        f.add(b,BorderLayout.CENTER);
        f.setSize(200,200);
        f.setVisible(true);
    }
}

class MyButtonListener implements ActionListener {
    @Override//��д
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
        System.out.println("��");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("�ر���");
        //System.exit(0);
        this.f.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("�ѹر�");
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