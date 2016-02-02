package com.madislav.store.controller;
//Created by Luladik on 2/2/2016.

import com.madislav.store.model.Customer;
import com.madislav.store.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId, @RequestParam String password,
                              HttpSession session, Model model) {
        Customer customer = customerService.loginCustomer(userId, password);
        if (customer == null) {
            model.addAttribute("loginError", "Error logging in. Please, try again");
            return "login";
        }
        model.addAttribute("loggedInUser", customer);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }

}

