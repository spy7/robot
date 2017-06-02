package robot.helper;

import configuration.NasaConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import robot.entity.Direction;
import robot.exception.NasaException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by: csanches on 02/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NasaConfiguration.class)
public class DirectionHelperTest {

    @Autowired
    DirectionHelper directionHelper;

    @Test
    public void testToChar() {
        assertEquals("Wrong char", 'N', directionHelper.toChar(Direction.NORTH));
        assertEquals("Wrong char", 'E', directionHelper.toChar(Direction.EAST));
        assertEquals("Wrong char", 'S', directionHelper.toChar(Direction.SOUTH));
        assertEquals("Wrong char", 'W', directionHelper.toChar(Direction.WEST));
    }

    @Test
    public void testRotateClockwise() {
        assertEquals("Wrong rotation clockwise", Direction.EAST, directionHelper.rotateClockwise(Direction.NORTH));
        assertEquals("Wrong rotation clockwise", Direction.SOUTH, directionHelper.rotateClockwise(Direction.EAST));
        assertEquals("Wrong rotation clockwise", Direction.WEST, directionHelper.rotateClockwise(Direction.SOUTH));
        assertEquals("Wrong rotation clockwise", Direction.NORTH, directionHelper.rotateClockwise(Direction.WEST));
    }

    @Test
    public void testRotateCounterclockwise() {
        assertEquals("Wrong rotation counterclockwise", Direction.WEST, directionHelper.rotateCounterclockwise(Direction.NORTH));
        assertEquals("Wrong rotation counterclockwise", Direction.NORTH, directionHelper.rotateCounterclockwise(Direction.EAST));
        assertEquals("Wrong rotation counterclockwise", Direction.EAST, directionHelper.rotateCounterclockwise(Direction.SOUTH));
        assertEquals("Wrong rotation counterclockwise", Direction.SOUTH, directionHelper.rotateCounterclockwise(Direction.WEST));
    }

    @Test(expected = NasaException.class)
    public void testToCharNull() {
        directionHelper.toChar(null);
    }

    @Test(expected = NasaException.class)
    public void testRotateNull() {
        directionHelper.rotateClockwise(null);
    }
}