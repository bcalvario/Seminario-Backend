package com.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.*;

@RestController
public class CtrlCategory {
    
    @GetMapping("/category")
    public String GetCategory() {

        Category categories = new Category();

        ArrayList<Category> categoriesList = new ArrayList<Category>();

        categoriesList.add(categories.createCategory("1", "Abarrotes"));
        categoriesList.add(categories.createCategory("2", "Electrónica"));
        categoriesList.add(categories.createCategory("3", "Línea Blanca"));
        
        return new Gson().toJson(categoriesList);
    }

}
