package com.example.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontController")
public class FrontController {


    @GetMapping("/getInfo")
    public String getInfo()
    {
        return "getinfo successfully";
    }
}
