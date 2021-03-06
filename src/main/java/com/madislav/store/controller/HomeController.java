package com.madislav.store.controller;

import com.madislav.store.model.Category;
import com.madislav.store.model.Product;
import com.madislav.store.model.service.CategoryService;
import com.madislav.store.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        List<Product> featuredProducts = productService.getFeaturedProducts();

        model.addAttribute("productList", featuredProducts);
        return "home";
    }


    @ModelAttribute("allCategories")
    public List<Category> fetchAllCategories() {
        return categoryService.getAllCategories();
    }

//	@ExceptionHandler(Exception.class)
//	public ModelAndView resolveException(HttpServletRequest request,
//										 HttpServletResponse response, Object handler, Exception exception) {
////		logger.error("Request: " + request.getRequestURL() + " raised " + exception);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", exception);
//		mav.setViewName("error");
//		return mav;
//	}
}