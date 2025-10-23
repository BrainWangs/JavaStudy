package draw.moving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class runABowl extends JFrame {

    public static void main(String[] args) {
        new runABowl();
    }

    public runABowl() {
        MyPanel01 mp = new MyPanel01();
        this.add(mp);
        this.addKeyListener((KeyListener) mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("移动小球");

    }
}

// 构造小球容器, 并实现键盘监听
class MyPanel extends JPanel implements KeyListener {
    // 声明类字段, 可供监听器使用
    int x = 10, y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.cyan);
        g.fillOval(x, y, 30, 30);

    }


    /*
    * 当键盘输入字符时响应
    * 处理范围包含ASCII码的范围
    * 此方法不能处理getKeyCode(), 因为后者处理物理按键的键码
    * */
    @Override
    public void keyTyped(KeyEvent e) {
        // System.out.println("typed : " + e.getKeyChar());
    }

    /*
    * 当键盘按下时响应
    * 处理范围是所有键盘按键(键盘按键的键码)
    *
    * */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { // 按下下方向键
            y += 5;

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;

        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 5;

        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 5;

        }
        this.repaint();
        System.out.println("现在的坐标是 " + x + " " + y);
    }

    /*
    * 当键盘释放时响应
    * 处理范围是所有键盘按键(键盘按键的键码)
    * */
    @Override
    public void keyReleased(KeyEvent e) {
        // System.out.println("released : " + (char)e.getKeyCode());
    }
}
