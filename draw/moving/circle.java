package draw.moving;

import javax.swing.*;
import java.awt.*;


public class circle extends JFrame{
    public static void main(String[] args) {
        new circle();

    }

    // 这是类的构造器
    public circle() {
        // 创建一个MyPanel对象，用于绘制图形
        MyPanel01 mp = new MyPanel01();
        // 将面板添加到窗口中
        this.add(mp);
        // 设置窗口标题为"画圆"
        this.setTitle("画圆");
        // 设置窗口大小为400像素宽，300像素高
        this.setSize(400, 300);
        // 设置窗口可见性
        this.setVisible(true);
        // 设置窗口关闭时结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

/***
 * paint方法的调用是一个自动过程，不是由程序员直接调用的。
 * Paint方法的调用时机
 * 系统自动调用：当组件第一次显示时，Swing系统会自动调用paint方法来绘制组件。
 * 窗口重绘时：当窗口被其他窗口遮挡后重新显示、窗口大小改变或者从最小化恢复时，系统会自动调用paint方法。
 * 调用repaint方法后：当程序员调用repaint方法时，系统会在稍后的某个时间点自动调用paint方法来更新显示。
 */

class MyPanel01 extends JPanel {

    /*由于这里没有构造器, 会默认调用父类构造器*/
    @Override
    // 重写paint方法来定义如何绘制组件
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10, 10, 100, 100);
        g.drawLine(10, 10, 110, 110);
        g.drawRect(10, 10, 100, 100);
    }
}
