package robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import robot.entity.Robot;
import robot.exception.NasaException;
import robot.helper.DirectionHelper;
import robot.validate.RobotValidate;

/**
 * Created by: csanches on 01/06/2017.
 */
@Controller
public class RobotController {

    @Autowired
    private DirectionHelper directionHelper;

    @Autowired
    private RobotValidate robotValidate;

    public void move(Robot robot, String path) {
        for (char way : path.toUpperCase().toCharArray()) {
            switch (way) {
                case 'M':
                    forward(robot);
                    robotValidate.validateRobot(robot);
                    break;
                case 'R':
                    robot.setDirection(directionHelper.rotateClockwise(robot.getDirection()));
                    break;
                case 'L':
                    robot.setDirection(directionHelper.rotateCounterclockwise(robot.getDirection()));
                    break;
                default:
                    throw new NasaException("Invalid path");
            }
        }
    }

    private void forward(Robot robot) {
        robot.setX(robot.getX() + robot.getDirection().getDirectionX());
        robot.setY(robot.getY() + robot.getDirection().getDirectionY());
    }

    public String showCoordinates(Robot robot) {
        return String.format("(%d, %d, %s)", robot.getX(), robot.getY(), directionHelper.toChar(robot.getDirection()));
    }
}
