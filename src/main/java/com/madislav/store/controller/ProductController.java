package com.madislav.store.controller;

import com.madislav.store.model.Product;
import com.madislav.store.model.service.CategoryService;
import com.madislav.store.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

//	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(params = "ftl")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "productlist";
    }

    @RequestMapping(value = "/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") Product product,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "product/create";
        }
        productService.saveProduct(product);
        return "redirect:/products/" + product.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result) {
//        if (result.hasErrors()) {
//            System.out.println(result.getAllErrors());
//            return "product/register";
//        }
        productService.updateProduct(product);
        return "redirect:/products/" + product.getId();
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView getProduct(@PathVariable("id") Long productId) {
        Product product = productService.findProduct(productId);
        return new ModelAndView("product/view", "product", product);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editProduct(@Valid @PathVariable("id") Long productId,
                              Map<String, Object> model) {
        Product product = productService.findProduct(productId);
        model.put("product", product);
        model.put("categories", categoryService.getAllCategories());
        return "product/edit";
    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView errorHandler(HttpServletRequest req, Exception exception) {
////	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", exception);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }


}
