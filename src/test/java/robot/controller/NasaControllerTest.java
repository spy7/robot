package robot.controller;

import configuration.NasaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 * Created by: csanches on 02/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NasaConfiguration.class)
public class NasaControllerTest {

    @Autowired
    private NasaController nasaController;

    @Test
    public void testMoveRobotMMRMMRMM() {
        assertEquals("invalid robot position", "(2, 0, S)", nasaController.moveRobot("MMRMMRMM"));
    }

    @Test
    public void testMoveRobotMML() {
        assertEquals("invalid robot position", "(0, 2, W)", nasaController.moveRobot("MML"));
    }

    @Test
    public void testMoveRobot() {
        assertEquals("invalid robot position", "400 Bad Request", nasaController.moveRobot("AAA"));
    }
}