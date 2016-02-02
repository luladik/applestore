package com.madislav.store.controller;
//Created by Luladik on 2/1/2016.

import com.madislav.store.ProductSearchValidator;
import com.madislav.store.model.Category;
import com.madislav.store.model.Product;
import com.madislav.store.model.service.CategoryService;
import com.madislav.store.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class SearchController {

    @Autowired
    ProductSearchValidator productSearchValidator;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/search")
    public String searchForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/search";
    }

    @RequestMapping
    public String processSearch(@Valid Product product, BindingResult bindingResult, Model model) {
        List<Product> results = productService.findProducts(product);
        if (results.size() < 1) {
            bindingResult.rejectValue("name", "notFound", "Sorry, no results found");
        }
        if (results.size() == 1) {
            product = results.get(0);
            return "redirect:products/" + product.getId();
        } else {
            model.addAttribute("results", results);
            return "product/search";
        }
    }

    @ModelAttribute
    public List<Category> fetchAllCategories() {
        return categoryService.getAllCategories();
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(productSearchValidator);
    }
}
