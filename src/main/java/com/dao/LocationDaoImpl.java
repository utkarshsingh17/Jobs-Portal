/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.Location;
import com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kali
 */
public class LocationDaoImpl implements ILocationDao{

  Connection con=null;
   PreparedStatement ps=null;
   ResultSet rs=null;

    

    public List<Location> getAllLocation() {
        List<Location> list = new ArrayList<>();
        try {
            con=JdbcUtil.getJdbcConnection();
            String query = "select * from location";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Location l = new Location();
                l.setId(rs.getInt("id"));
                l.setlName(rs.getString("lName"));

                list.add(l);
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
        return list;
    }
}
