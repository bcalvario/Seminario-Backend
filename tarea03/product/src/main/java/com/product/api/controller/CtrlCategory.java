package com.product.api.controller;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.entity.Category;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CtrlCategory {

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {

        Category category1 = new Category();
        category1.setCategory_id(1);
        category1.setCategory("Abarrotes");
        category1.setStatus(1);

        Category category2 = new Category();
        category2.setCategory_id(2);
        category2.setCategory("Electrónica");
        category2.setStatus(1);

        List categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<Category> getCategory(@PathVariable int category_id) {

        Category category1 = new Category();
        category1.setCategory_id(category_id);
        category1.setCategory("Abarrotes");
        category1.setStatus(1);

        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {

        String message = "";

        if (bindingResult.hasErrors()) {

            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        
        Category category1 = new Category();
        category1.setCategory_id(1);
        category1.setCategory("Abarrotes");
        category1.setStatus(1);

        Category category2 = new Category();
        category2.setCategory_id(2);
        category2.setCategory("Electrónica");
        category2.setStatus(1);


        /*( category1.getCategory().equals(category.getCategory()) && category1.getCategory_id().equals(category.getCategory_id()) && category1.getStatus().equals(category.getStatus()) ) */
        if ( (category1.getCategory().equals(category.getCategory()) && category1.getCategory_id().equals(category.getCategory_id())) || category2.getCategory().equals(category.getCategory()) && (category2.getCategory_id().equals(category.getCategory_id())) ) {
            
            message = "category already exist";
        
        } else {

            message = "category created";

        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<String> updateCategory(@PathVariable int category_id, @Valid @RequestBody Category category, BindingResult bindingResult) {

        String message = "";

        if (bindingResult.hasErrors()) {

            message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        
        Category category1 = new Category();
        category1.setCategory_id(1);
        category1.setCategory("Abarrotes");
        category1.setStatus(1);

        Category category2 = new Category();
        category2.setCategory_id(2);
        category2.setCategory("Electrónica");
        category2.setStatus(1);


        /*( category1.getCategory().equals(category.getCategory()) && category1.getCategory_id().equals(category.getCategory_id()) && category1.getStatus().equals(category.getStatus()) ) */
        if ( category1.getCategory_id().equals(category_id) || category2.getCategory_id().equals(category_id) ) {
            
            message = "category updated";
        
        } else {

            message = "category does not exist";

        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer category_id) {

        String message = "";

        Category category1 = new Category();
        category1.setCategory_id(1);
        category1.setCategory("Abarrotes");
        category1.setStatus(1);

        Category category2 = new Category();
        category2.setCategory_id(2);
        category2.setCategory("Electrónica");
        category2.setStatus(1);


        if ( category1.getCategory_id().equals(category_id) || category2.getCategory_id().equals(category_id) ) {
            
            message = "category removed";
        
        } else {

            message = "category does not exist";

        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    
}
