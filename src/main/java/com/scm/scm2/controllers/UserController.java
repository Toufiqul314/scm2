package com.scm.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard page
    @RequestMapping(value = "/dashboard")
    public String userDashbord( ) {
        return "user/dashboard";
    }

    //user profile page
    @RequestMapping(value = "/profile")
    public String userProfile() {
        return "user/profile";
    }
    

    //user add contacts page

    //user view contacts

    //user edit contact page

    //user delete contact page

    //user search contacts page

}
