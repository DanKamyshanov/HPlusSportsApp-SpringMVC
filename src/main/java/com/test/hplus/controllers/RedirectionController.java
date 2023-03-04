package com.test.hplus.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

    private static final Logger logger = Logger.getLogger(RedirectionController.class);

    @GetMapping("/redirectToLinkedIn")
    public String redirectOut(){
        logger.info("In redirect controller");
        return "redirect:http://www.linkedin.com";
    }
}
