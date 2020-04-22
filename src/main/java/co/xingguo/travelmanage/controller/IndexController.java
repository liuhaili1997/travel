package co.xingguo.travelmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Created by hailitortoise on 2020-04-17
 */
@Controller
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

}
