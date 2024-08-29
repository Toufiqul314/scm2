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
import com.scm.scm2.helpers.Message;
import com.scm.scm2.helpers.MessageType;

import jakarta.servlet.http.HttpSession;

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
    public String processSignup(@ModelAttribute UserForm userForm,HttpSession session) {
        //fetch form data
        //userForm
        System.out.println(userForm);
        //validate form data
        // if(bindingResult.hasErrors()){
        //     return "signup";
        // }

        //Todo::validate user form

        //save to database
        // userForm -> User 

        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://www.istockphoto.com/vector/profile-picture-vector-illustration-gm587805156-100912283?searchscope=image%2Cfilm")
        // .build();

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://www.istockphoto.com/vector/profile-picture-vector-illustration-gm587805156-100912283?searchscope=image%2Cfilm");
        //user.setPhoneNumber(userForm.getPhoneNumber());

        User saveUser=userService.savUser(user);
        System.out.println("user save :");

        //userservice

        
        //message="registration successful"

        //add the message
         Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",message);

        //redirect to login page

        return "redirect:/signup";
    }
}
