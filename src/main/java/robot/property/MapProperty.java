package robot.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by: csanches on 01/06/2017.
 */
@Component
@PropertySource("classpath:map.properties")
public class MapProperty {
    @Value("${map.width}")
    private int width;

    @Value("${map.height}")
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
