/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.ICategoryDao;
import com.daoFactory.CategoryDaoFactory;
import com.dto.Category;
import java.util.List;

/**
 *
 * @author kali
 */
public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao=null;
    @Override
     public List<Category> getAllCategory() {
         categoryDao=CategoryDaoFactory.getCategoryDao();
         return categoryDao.getAllCategory();
         
     }
}
