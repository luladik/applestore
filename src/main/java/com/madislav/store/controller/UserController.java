package com.madislav.store.controller;

import com.madislav.store.model.Customer;
import com.madislav.store.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

//Created by Luladik on 1/28/2016.
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(params = "registration")
    public String createForm(Model model) {
        model.addAttribute("user", new Customer());
        return "user/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return "user/registration";
        }
        customerService.saveCustomer(customer);

        return "redirect:/users/" + customer.getName();
    }


    @RequestMapping(value = "/{userId}")
    public String getUserProfile(@PathVariable String userId, Map<String, Object> model) {

        Customer customer = customerService.findCustomer(userId);
        model.put("user", customer);
        return "user/view";
    }

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
    public String editUserProfile(@PathVariable("userId") String userId,
                                  Map<String, Object> model) {
        Customer customer = customerService.findCustomer(userId);
        model.put("user", customer);
        return "user/edit";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") @Valid Customer customer,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "user/registration";
        }
        customerService.updateCustomer(customer);
        return "redirect:/users/" + customer.getName();
    }


}
