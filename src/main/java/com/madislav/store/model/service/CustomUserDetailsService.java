package com.madislav.store.model.service;
//Created by Luladik on 3/19/2016.

import com.madislav.store.model.Customer;
import com.madislav.store.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService userService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {

        Customer customer = userService.findCustomer(ssoId);

        System.out.println("User:" + customer);
        System.out.println(customer.getName());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
        System.out.println("ziziziziziziziziziziziziziziziziziziziz");

        if (customer == null)
            throw new UsernameNotFoundException("Username not FOUND!!!");

        return new org.springframework.security.core.userdetails.User(customer.getName(),
                customer.getPassword(),
                true, true, true, true, getGrantedAuthorities(customer));

    }

    private List<GrantedAuthority> getGrantedAuthorities(Customer customer) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (UserProfile userProfile : customer.getUserProfiles()) {
            System.out.println("UserProfile : " + userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
        }
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}