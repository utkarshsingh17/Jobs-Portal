/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.UserComment;
import com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kali
 */
public class UserCommentDaoImpl implements IUserCommentDao {

  Connection con=null;
   PreparedStatement ps=null;
   ResultSet rs=null;

   

    public boolean insertUserComment(UserComment u) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "insert into users_problem_message(username, email, message) values(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getComment());
            Integer roll = ps.executeUpdate();

            if (roll == 1) {
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
