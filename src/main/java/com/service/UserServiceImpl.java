/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IUserDao;
import com.daoFactory.UserDaoFactory;
import com.dto.User;

/**
 *
 * @author kali
 */
public class UserServiceImpl implements IUserService {
    IUserDao userDao=null;
    public boolean addUser(User u) {
        userDao=UserDaoFactory.getUserDao();
        return userDao.addUser(u);
       
    }

    public User loginUser(String email, String password) {
         userDao=UserDaoFactory.getUserDao();
         
        return userDao.loginUser(email,password);
       
    }

    public boolean updateUser(User u) {
         userDao=UserDaoFactory.getUserDao();
        return userDao.updateUser(u);
     
    }
    
}
