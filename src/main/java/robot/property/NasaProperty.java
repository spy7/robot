package robot.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by: csanches on 01/06/2017.
 */
@Component
@PropertySource("classpath:nasa.properties")
public class NasaProperty {

    @Value("${message.error.badRequest}")
    private String badRequest;

    @Value("${message.error.invalidRobot}")
    private String invalidRobot;

    public String getBadRequest() {
        return badRequest;
    }

    public String getInvalidRobot() {
        return invalidRobot;
    }
}
