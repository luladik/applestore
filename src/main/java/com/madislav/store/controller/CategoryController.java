package com.madislav.store.controller;

import com.madislav.store.model.Category;
import com.madislav.store.model.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

//	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(params = "create")
	public String createForm(Model model) {
		model.addAttribute("category", new Category());
		return "category/create";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") @Valid Category category,
							  BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "category/create";
		}
		categoryService.saveCategory(category);
		return "redirect:/categories/" + category.getId();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateCategory(@Valid @ModelAttribute("category")  Category category,
								BindingResult result) {
//		if (result.hasErrors()) {
//			return "category/register";
//		}
		categoryService.updateCategory(category);
		return "redirect:/categories/" + category.getId();
	}
	@RequestMapping(value = "/{id}")
	public ModelAndView getCategory(@PathVariable("id") Long categoryId) {
		Category category = categoryService.findCategoryEagerly(categoryId);
		return new ModelAndView("category/view", "category", category);

	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editCategory(@Valid @PathVariable("id") Long categoryId,
							  Map<String, Object> model) {
		Category category = categoryService.findCategory(categoryId);
		model.put("category", category);
		return "category/edit";
	}
//
//	@ExceptionHandler(Exception.class)
//	public ModelAndView errorHandler(HttpServletRequest req, Exception exception) {
////	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", exception);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("product/error");
//		return mav;
//	}



}
