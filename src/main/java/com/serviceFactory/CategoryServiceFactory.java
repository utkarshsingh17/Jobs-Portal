/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.CategoryServiceImpl;
import com.service.ICategoryService;

/**
 *
 * @author kali
 */
public class CategoryServiceFactory {
     private CategoryServiceFactory(){
        
    }
    private static ICategoryService categoryService=null;
    public static ICategoryService getCategoryService(){
        if(categoryService==null){
            categoryService=new CategoryServiceImpl();
        }
        return categoryService;
    }
}
