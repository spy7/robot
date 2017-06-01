package robot.helper;

import robot.entity.Direction;
import robot.exception.NasaException;
import org.springframework.stereotype.Service;

/**
 * Created by: csanches on 01/06/2017.
 */
@Service
public class DirectionHelper {

    public char toChar(Direction direction) {
        try {
            return direction.toString().charAt(0);
        } catch (Exception e) {
            throw new NasaException("Invalid direction");
        }
    }

    public Direction rotateClockwise(Direction direction) {
        return rotate(direction, 1);
    }

    public Direction rotateCounterclockwise(Direction direction) {
        return rotate(direction, 3);
    }

    private Direction rotate(Direction direction, int steps) {
        try {
            Direction[] values = Direction.values();
            return values[(direction.ordinal() + steps) % values.length];
        } catch (Exception e) {
            throw new NasaException("Invalid direction");
        }
    }
}
