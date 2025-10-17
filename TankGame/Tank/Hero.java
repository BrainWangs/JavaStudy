package draw.TankGame.Tank;


/**
 * 玩家的坦克
 */
public class Hero extends Tank{
    public Hero(int x, int y, int dir, int type, int speed) {
        super(x, y, dir, type, speed);
        setType(0); // 玩家坦克(再次声明防止数据错误)
    }




}
