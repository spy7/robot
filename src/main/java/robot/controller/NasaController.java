package robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import robot.entity.Robot;
import robot.exception.NasaException;

/**
 * Created by: csanches on 01/06/2017.
 */
@Controller
@RequestMapping("/mars/{path}")
public class NasaController {

    @Autowired
    private RobotController robotController;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String moveRobot(@PathVariable String path) {

        try {

            Robot robot = new Robot();
            robotController.move(robot, path);

            return robotController.showCoordinates(robot);

        } catch (NasaException e) {
            return "400 Bad Request: " + e.getMessage();
        }
    }
}
