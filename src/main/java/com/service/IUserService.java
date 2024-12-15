/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dto.User;

/**
 *
 * @author kali
 */
public interface IUserService {
    public boolean addUser(User u);

    public User loginUser(String email, String password);
    public boolean updateUser(User u);
}