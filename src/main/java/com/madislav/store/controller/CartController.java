package com.madislav.store.controller;
//Created by Luladik on 2/4/2016.

import com.madislav.store.bean.Cart;
import com.madislav.store.model.Product;
import com.madislav.store.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    private Cart cart;

    @RequestMapping(value = "/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId,
                            @RequestHeader("referer") String referedFrom) {
        Product product = productService.findProduct(productId);
        cart.addProduct(product, 1);
        return "redirect:" + referedFrom;
    }
}
