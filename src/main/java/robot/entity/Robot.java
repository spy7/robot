package robot.entity;

/**
 * Created by: csanches on 01/06/2017.
 */
public class Robot {

    private Integer x;
    private Integer y;
    private Direction direction;

    public Robot() {
        x = 0;
        y = 0;
        direction = Direction.NORTH;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
