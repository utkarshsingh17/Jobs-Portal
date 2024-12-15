/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.User;
import com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MeGa
 */
public class UserDaoImpl implements IUserDao {

    Connection con=null;
   PreparedStatement ps=null;
   ResultSet rs=null;


    public boolean addUser(User u) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "insert into users(name,email,password,qualificaton,role) values(?,?,?,?,?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getQualification());
            ps.setString(5, "user");

            Integer i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    public User loginUser(String email, String password) {
        User user = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String login = "select * from users where email=? and password=?";
            ps = con.prepareStatement(login);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setQualification(rs.getString("qualificaton"));
                user.setRole(rs.getString("role"));
                user.setName(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return user;
    }

    public boolean updateUser(User u) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "update users set name=?, email=?,password=?,qualificaton=? where id =?";
            ps = con.prepareStatement(insert);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getQualification());
            ps.setInt(5, u.getId());

            Integer i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error : " + e.getMessage());
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }
}
