package nms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlelr {

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }
}
