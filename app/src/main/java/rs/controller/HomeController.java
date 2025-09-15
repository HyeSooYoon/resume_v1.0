package rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() { 

        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddsfsdf");
        return "index";
    }

    
    @GetMapping("/index")
    public String index2() { 

        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddsfsdf");
        return "index";
    }
}
