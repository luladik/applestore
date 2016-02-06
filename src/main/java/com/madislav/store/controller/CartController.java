package com.madislav.store.controller;
//Created by Luladik on 2/4/2016.

import com.madislav.store.bean.Cart;
import com.madislav.store.model.Customer;
import com.madislav.store.model.Product;
import com.madislav.store.model.service.ProductService;
import com.madislav.store.model.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @Autowired
    private Cart cart;
    @Autowired
    PurchaseService purchaseService;

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @RequestMapping(value = "/cart/add/{productId}")
    public String addToCart(@PathVariable("productId") Long productId,
                            @RequestHeader("referer") String referedFrom) {
        Product product = productService.findProduct(productId);
        cart.addProduct(product, 1);
        logger.debug("Adding product to a cart" + product.getName() + "::::" + product);
        return "redirect:" + referedFrom;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping(value = "/cart/placeOrder", method = RequestMethod.POST)
    public String placeOrder(HttpSession session, RedirectAttributes redirectAttributes) {
        if (cart.getContents().isEmpty()) {
            redirectAttributes.addAttribute("cartMessage", "Cart is empty. Please, add products to the cart");
            return "redirect:/cart";
        } else {
            Customer loggedInUser = (Customer) session.getAttribute("loggedInUser");
            purchaseService.savePurchase(cart.getContents(), loggedInUser);
            cart.clearCart();
            return "redirect:/cart";
        }
    }
}


