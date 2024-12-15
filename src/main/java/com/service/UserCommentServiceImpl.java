/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IUserCommentDao;
import com.daoFactory.UserCommentDaoFactory;
import com.dto.UserComment;

/**
 *
 * @author kali
 */
public class UserCommentServiceImpl implements IUserCommentService{
    IUserCommentDao userCommentDao=null;
     public boolean insertUserComment(UserComment u){
         userCommentDao=UserCommentDaoFactory.getUserCommentDao();
         return userCommentDao.insertUserComment(u);
         
     }
}
