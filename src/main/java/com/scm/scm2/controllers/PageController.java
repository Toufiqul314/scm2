package com.scm.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Welcome to SCM2!");
        return "home";
    }

    //about route
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        // model.addAttribute("isLogin",true);
        return "about";
    }
    //services route
    @RequestMapping("/services")
    public String servicesPage(){
        return "services";
    }
}
