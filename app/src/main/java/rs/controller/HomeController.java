package rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {  
    @GetMapping("/index")
    public String index() {
        return "forward:/index.html";
    } 

    @GetMapping("/about")
    public String about() {
        return "forward:/about/index.html";
    } 

    @GetMapping("/category")
    public String category() {
        return "forward:/category/index.html";
    


    }


    
}
