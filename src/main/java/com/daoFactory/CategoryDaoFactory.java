/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.CategoryDaoImpl;
import com.dao.ICategoryDao;

/**
 *
 * @author kali
 */
public class CategoryDaoFactory {
       private CategoryDaoFactory(){
        
    }
    private static ICategoryDao categoryDao=null;
    public static ICategoryDao getCategoryDao(){
        if(categoryDao==null){
            categoryDao=new CategoryDaoImpl();
        }
        return categoryDao;
    }
}
