package com.fpt.t2010ahellospring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hello")
public class HelloController {

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public String say(){
        return "Hello World";
    }

    /*path variable*/
    @RequestMapping(path = "{id}",method = RequestMethod.POST)
    public String postsay(){
        return "Hello World";
    }

    @GetMapping(path = "test")
    public String test(){
        return "Testing";
    }
    @RequestMapping(path = "talk",method = RequestMethod.GET)
    public String talk(){
        return "Talk";
    }
}
