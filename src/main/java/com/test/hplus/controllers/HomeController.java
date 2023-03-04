package com.test.hplus.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger logger = Logger.getLogger(HomeController.class);

    @GetMapping("/home")
    public String goHome(){
        logger.info("In home controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        logger.info("Going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(){
        logger.info("Going to login page");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration(){
        logger.info("Going to registration page");
        return "register";
    }
 }
