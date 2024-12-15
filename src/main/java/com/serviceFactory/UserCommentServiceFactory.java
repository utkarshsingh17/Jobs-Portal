/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.IUserCommentService;
import com.service.UserCommentServiceImpl;

/**
 *
 * @author kali
 */
public class UserCommentServiceFactory {
      private UserCommentServiceFactory(){
        
    }
    private static IUserCommentService userCommentService=null;
    public static IUserCommentService getUserCommentService(){
        if(userCommentService==null){
            userCommentService=new UserCommentServiceImpl();
        }
        return userCommentService;
    }
}
