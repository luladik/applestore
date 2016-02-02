package com.madislav.store.controller;

import com.madislav.store.model.Product;
import com.madislav.store.model.service.CategoryService;
import com.madislav.store.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(params = "ftl")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.findAllProducts());
		return "productlist";
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "product/create";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("categories", categoryService.getAllCategories());
			return "product/create";
		}
		productService.saveProduct(product);
		return "redirect:/products/" + product.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") @Valid Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "product/register";
		}
		productService.updateProduct(product);
		return "redirect:/products/" + product.getId();
	}
	@RequestMapping(value = "/{id}")
	public ModelAndView getProduct(@PathVariable("id") Long productId) {
		Product product = productService.findProduct(productId);
		return new ModelAndView("product/view", "product", product);
		
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long productId,
			Map<String, Object> model) {
		Product product = productService.findProduct(productId);
		model.put("product", product);
		model.put("categories", categoryService.getAllCategories());
		return "product/edit";
	}

	@ExceptionHandler(Exception.class)
	  public ModelAndView errorHandler(HttpServletRequest req, Exception exception) {
//	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("product/error");
	    return mav;
	  }

	
	
}
