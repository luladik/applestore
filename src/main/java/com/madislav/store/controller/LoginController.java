package com.madislav.store.controller;
//Created by Luladik on 2/2/2016.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(Model model) {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String verifyLogin() {
//
//        return "redirect:/";
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {

        return "login";
    }

}

