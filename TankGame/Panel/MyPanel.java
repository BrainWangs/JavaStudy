package draw.TankGame.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import draw.TankGame.Tank.Tank;
import draw.TankGame.Tank.Hero;

/**
 *
 * 下面是游戏背景绘图区域
 */

public class MyPanel extends JPanel implements KeyListener {

    Hero hero = new Hero(100, 100, 0, 0, 10);
    Tank enemyTank01 = new Tank(300, 300, 0, 1, 10);

    // 重写Paint方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 设置窗口大小
        g.setColor(Color.BLACK); // 设置颜色


        // 通过创建对象生成坦克

        drawTank(hero.getX(), hero.getY(), g, hero.getDir(), hero.getType());
        drawTank(enemyTank01.getX(), enemyTank01.getY(), g, enemyTank01.getDir(), enemyTank01.getType());
    }

    /**
     * 编写生成坦克图案的方法
     * @param x         坦克的横坐标
     * @param y         坦克的纵坐标
     * @param g         画笔
     * @param direction 坦克的方向(0: 向上 1: 向右 2: 向下 3: 向左)
     * @param type      坦克的类型(0: 玩家坦克 1: 敌人坦克)
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        // 绘制坦克颜色
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }

        // 绘制坦克图形
        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false); // left
                g.fill3DRect(x+30, y, 10, 60, false); // right
                g.fill3DRect(x+10, y+10, 20, 40, false); // body
                g.fillOval(x+10, y+20, 20, 20); // circle
                g.drawLine(x+20, y+30, x+20, y);
                break;

            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y+30, 60, 10, false);
                g.fill3DRect(x+10, y+10, 40, 20, false);
                g.fillOval(x+20, y+10, 20, 20);
                g.drawLine(x+30, y+20, x+60, y+20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x+30, y, 10, 60, false);
                g.fill3DRect(x+10, y+10, 20, 40, false);
                g.fillOval(x+10, y+20, 20, 20);
                g.drawLine(x+20, y+30, x+20, y+60);
                break;

            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y+30, 60, 10, false);
                g.fill3DRect(x+10, y+10, 40, 20, false);
                g.fillOval(x+20, y+10, 20, 20);
                g.drawLine(x+30, y+20, x, y+20);
                break;

            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 顺序是上右下左 0123
        switch (e.getKeyChar()) {
            case 'w':
                hero.move(0);
                hero.setDir(0);
                break;
            case 'd' :
                hero.move(1);
                hero.setDir(1);
                break;
            case 's':
                hero.move(2);
                hero.setDir(2);
                break;
            case 'a':
                hero.move(3);
                hero.setDir(3);
                break;
            default:
                break;
        }
        this.repaint();
        /*注意repaint()方法会重新运行paint()方法*/

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
