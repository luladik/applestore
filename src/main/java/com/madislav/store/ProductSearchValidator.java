package com.madislav.store;
//Created by Luladik on 2/2/2016.

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.madislav.store.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductSearchValidator implements Validator {

    public boolean supports(Class<?> cls) {
        return Product.class.isAssignableFrom(cls);
    }

    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        String name = product.getName();
        if (!StringUtils.hasLength(name) && product.getCategory() == null) {
            errors.rejectValue("name", "required", "Either name or category is required");
        } else if (product.getCategory() == null && name.trim().length() < 3) {
            errors.rejectValue("name", "tooShort", "Please enter at least 3 letters");
        }
    }

}
