package com.test.hplus.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    private static final Logger logger = Logger.getLogger(LogoutController.class);

    @GetMapping("/logout")
    public String logout(HttpSession session){
        logger.info("Ending user session");
        session.invalidate();
        return "login";
    }
}
