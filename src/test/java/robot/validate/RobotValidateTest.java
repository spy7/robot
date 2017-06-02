package robot.validate;

import configuration.NasaConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import robot.entity.Direction;
import robot.entity.Robot;
import robot.exception.NasaException;

/**
 * Created by: csanches on 02/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NasaConfiguration.class)
public class RobotValidateTest {

    @Autowired
    RobotValidate robotValidate;

    @Test
    public void testSuccess() {
        try {
            robotValidate.validateRobot(createRobot());
        } catch (NasaException e) {
            Assert.fail("success test fail");
        }
    }

    @Test(expected = NasaException.class)
    public void testValidateWithoutRobot() {
        robotValidate.validateRobot(null);
    }

    @Test(expected = NasaException.class)
    public void testValidateWithoutDirection() {
        Robot robot = createRobot();
        robot.setDirection(null);
        robotValidate.validateRobot(robot);
    }

    @Test(expected = NasaException.class)
    public void testValidateWithoutCoordinates() {
        Robot robot = createRobot();
        robot.setX(null);
        robotValidate.validateRobot(robot);
    }

    @Test(expected = NasaException.class)
    public void testValidateWithWrongCoordinates() {
        Robot robot = createRobot();
        robot.setX(-1);
        robotValidate.validateRobot(robot);
    }

    @Test(expected = NasaException.class)
    public void testValidateWithOutsideCoordinates() {
        Robot robot = createRobot();
        robot.setX(6);
        robotValidate.validateRobot(robot);
    }

    private Robot createRobot() {
        Robot robot = new Robot();
        robot.setX(2);
        robot.setY(3);
        robot.setDirection(Direction.NORTH);
        return robot;
    }
}