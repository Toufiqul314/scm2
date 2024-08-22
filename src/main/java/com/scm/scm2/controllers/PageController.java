package com.scm.scm2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm2.Services.UserService;
import com.scm.scm2.entities.User;
import com.scm.scm2.forms.UserForm;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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

    //contact page
    @RequestMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    //login page
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    //signup page
    @RequestMapping("/signup")
    public String signupPage(Model model){

        UserForm userForm = new UserForm();
        //default data are using in signup page
        //userForm.setName("tusher");
        model.addAttribute("userForm",userForm);

        return "signup";
    }

    //processing register/signup
    @RequestMapping(value="/do-register",method = RequestMethod.POST)
    public String processSignup(@ModelAttribute UserForm userForm) {
        //fetch form data
        //userForm
        System.out.println(userForm);
        //validate form data
        //Todo::validate userform

        //save to database
        // userForm -> User 
        User user=User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        .profilePic("https://www.istockphoto.com/vector/profile-picture-vector-illustration-gm587805156-100912283?searchscope=image%2Cfilm")
        .build();
        
        User saveUser=userService.savUser(user);
        System.out.println("user save :");

        //userservice

        
        //message="registration successful"
        //redirect to login page

        return "redirect:/signup";
    }
}
