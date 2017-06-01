package entity;

/**
 * Created by: csanches on 01/06/2017.
 */
public class Robot {

    private int x;
    private int y;
    private Direction direction;

    public Robot() {
        x = 0;
        y = 0;
        direction = Direction.NORTH;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
