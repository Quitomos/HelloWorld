package cn.quitomos.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        if (true)
            throw new Exception("a exception");
        return "hello!";
    }
}
