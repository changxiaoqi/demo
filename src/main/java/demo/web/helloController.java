package demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class helloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello!!!";
    }
}
