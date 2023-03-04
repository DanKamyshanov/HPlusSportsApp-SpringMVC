package com.test.hplus.controllers;

import com.test.hplus.beans.Login;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    private static final Logger logger = Logger.getLogger(UserProfileController.class);

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model){
        logger.info("In user profile controller.\nUsername from session: " + login.getUsername());
        model.addAttribute("username", login.getUsername());
        return "profile";
    }
}
