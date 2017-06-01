package controller;

import entity.Robot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by: csanches on 31/05/2017.
 */
@Controller
@RequestMapping("/mars/{path}")
public class NasaController {

    @RequestMapping(method = RequestMethod.GET)
    public String moveRobot(@PathVariable String path) {
        return new Robot().toString();
    }
}
