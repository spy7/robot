package configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by: csanches on 01/06/2017.
 */
@SpringBootApplication
@ComponentScan({"robot"})
public class NasaConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(NasaConfiguration.class, args);
    }

}
