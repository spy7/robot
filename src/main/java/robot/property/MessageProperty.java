package robot.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by: csanches on 01/06/2017.
 */
@Component
@PropertySource("classpath:message.properties")
public class MessageProperty {

    @Value("${message.error.badRequest}")
    private String badRequest;

    @Value("${message.error.invalidRobot}")
    private String invalidRobot;

    @Value("${message.error.invalidRobotDirection}")
    private String invalidRobotDirection;

    @Value("${message.error.invalidRobotCoordinates}")
    private String invalidRobotCoordinates;

    @Value("${message.error.invalidDirection}")
    private String invalidDirection;

    @Value("${message.error.invalidPath}")
    private String invalidPath;

    public String getBadRequest() {
        return badRequest;
    }

    public String getInvalidRobot() {
        return invalidRobot;
    }

    public String getInvalidRobotDirection() {
        return invalidRobotDirection;
    }

    public String getInvalidRobotCoordinates() {
        return invalidRobotCoordinates;
    }

    public String getInvalidDirection() {
        return invalidDirection;
    }

    public String getInvalidPath() {
        return invalidPath;
    }
}
