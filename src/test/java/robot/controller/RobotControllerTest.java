package robot.controller;

import configuration.NasaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import robot.entity.Direction;
import robot.entity.Robot;
import robot.exception.NasaException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by: csanches on 01/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NasaConfiguration.class)
public class RobotControllerTest {

    @Autowired
    RobotController robotController;

    @Test
    public void testMoveMMRMMRMM() {
        Robot robot = new Robot();
        robotController.move(robot, "MMRMMRMM");
        assertRobot(2, 0, Direction.SOUTH, robot);
    }

    @Test
    public void testMoveMML() {
        Robot robot = new Robot();
        robotController.move(robot, "MML");
        assertRobot(0, 2, Direction.WEST, robot);
    }

    @Test(expected = NasaException.class)
    public void testMoveInvalid() {
        Robot robot = new Robot();
        robotController.move(robot, "AAA");
    }

    @Test(expected = NasaException.class)
    public void testMoveOutside() {
        Robot robot = new Robot();
        robotController.move(robot, "MMMMMMMMMMMMMMMMMMMMMMMM");
    }

    private void assertRobot(int expectedX, int expectedY, Direction expectedDirection, Robot robot) {
        assertEquals("invalid robot coordinate X", expectedX, (int) robot.getX());
        assertEquals("invalid robot coordinate Y", expectedY, (int) robot.getY());
        assertEquals("invalid robot direction", expectedDirection, robot.getDirection());
    }

    @Test
    public void testShowCoordinates() {
        Robot robot = new Robot();
        robot.setX(2);
        robot.setY(3);
        robot.setDirection(Direction.WEST);
        assertEquals("invalid shown coordinates", "(2, 3, W)", robotController.showCoordinates(robot));
    }
}