package com.example.elk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {
    private  static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("home1")
    public String home() {
        logger.info("home1");
        return "Hello World";
    }

    @GetMapping("home2")
    public String home2() {
        try {
            logger.info("home2");
           return "home2";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
