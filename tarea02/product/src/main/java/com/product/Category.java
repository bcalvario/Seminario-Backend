package com.product;

import java.util.*;

public class Category {
    
    String category_id;  
    String category;  
    
    Category (String categoryId, String categoryName) {
        
        category_id = categoryId;
        category = categoryName;
    
    }

    Category () {}
    
    
    public Category createCategory(String categoryId, String categoryName) {
        
        return new Category(categoryId, categoryName);
    
    }
    
    public String getCategories(ArrayList<Category> categories) {
        
        if (categories.size() == 0) {

            return "No existen categorias registradas";

        } else {

            String categoriesString = "(";
        
            for (int i = 0; i < categories.size(); i++) {

                categoriesString += "(" + categories.get(i).category_id + ", " + categories.get(i).category + ")";

            }
        
            return categoriesString + ")";

        }
    }

    public String getCategory(String categoryId, ArrayList<Category> categories) {
        
        Category category = new Category();

        for (int i = 0; i < categories.size(); i++) {
            
            if (categories.get(i).category_id.equals(categoryId)) {

                category.category_id = categories.get(i).category_id;
                category.category = categories.get(i).category;
                break;

            }
        
        }
        
        return "(" + category.category_id + ", " + category.category + ")";

    }

    public void deleteCategory(String categoryId, ArrayList<Category> categories) {

        for (int i = 0; i < categories.size(); i++) {
            
            if (categories.get(i).category_id.equals(categoryId)) {

                categories.remove(i);
                
                break;

            }
        
        }

    }
    
}