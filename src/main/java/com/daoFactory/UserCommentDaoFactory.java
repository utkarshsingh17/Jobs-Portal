/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.IUserCommentDao;
import com.dao.UserCommentDaoImpl;

/**
 *
 * @author kali
 */
public class UserCommentDaoFactory {
    private UserCommentDaoFactory(){
        
    }
    private static IUserCommentDao userCommentDao=null;
    public static IUserCommentDao getUserCommentDao(){
        if(userCommentDao==null){
            userCommentDao=new UserCommentDaoImpl();
        }
        return userCommentDao;
    }
}
