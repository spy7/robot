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
        assertEquals("wrong char", 'N', directionHelper.toChar(Direction.NORTH));
        assertEquals("wrong char", 'E', directionHelper.toChar(Direction.EAST));
        assertEquals("wrong char", 'S', directionHelper.toChar(Direction.SOUTH));
        assertEquals("wrong char", 'W', directionHelper.toChar(Direction.WEST));
    }

    @Test
    public void testRotateClockwise() {
        assertEquals("wrong rotation clockwise", Direction.EAST, directionHelper.rotateClockwise(Direction.NORTH));
        assertEquals("wrong rotation clockwise", Direction.SOUTH, directionHelper.rotateClockwise(Direction.EAST));
        assertEquals("wrong rotation clockwise", Direction.WEST, directionHelper.rotateClockwise(Direction.SOUTH));
        assertEquals("wrong rotation clockwise", Direction.NORTH, directionHelper.rotateClockwise(Direction.WEST));
    }

    @Test
    public void testRotateCounterclockwise() {
        assertEquals("wrong rotation counterclockwise", Direction.WEST, directionHelper.rotateCounterclockwise(Direction.NORTH));
        assertEquals("wrong rotation counterclockwise", Direction.NORTH, directionHelper.rotateCounterclockwise(Direction.EAST));
        assertEquals("wrong rotation counterclockwise", Direction.EAST, directionHelper.rotateCounterclockwise(Direction.SOUTH));
        assertEquals("wrong rotation counterclockwise", Direction.SOUTH, directionHelper.rotateCounterclockwise(Direction.WEST));
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