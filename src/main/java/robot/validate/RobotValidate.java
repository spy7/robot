package robot.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import robot.entity.Robot;
import robot.exception.NasaException;
import robot.property.MapProperty;
import robot.property.MessageProperty;

/**
 * Created by: csanches on 01/06/2017.
 */
@Service
public class RobotValidate {

    @Autowired
    private MessageProperty messageProperty;

    @Autowired
    private MapProperty map;

    public void validateRobot(Robot robot) {
        if (robot == null) {
            throw new NasaException(messageProperty.getInvalidRobot());
        }

        if (robot.getDirection() == null) {
            throw new NasaException(messageProperty.getInvalidRobotDirection());
        }

        if (robot.getX() == null || robot.getY() == null || robot.getX() < 0 || robot.getY() < 0) {
            throw new NasaException(messageProperty.getInvalidRobotCoordinates());
        }

        if (map != null && (robot.getX() >= map.getWidth() || robot.getY() >= map.getHeight())) {
            throw new NasaException(messageProperty.getInvalidRobotCoordinates());
        }
    }

}
