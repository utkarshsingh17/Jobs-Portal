/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.dto.Jobs;
import com.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MeGa
 */
public class JobsDaoImpl implements IJobsDao{

    Connection con=null;
   PreparedStatement ps=null;
   ResultSet rs=null;

   

    public boolean addJobs(Jobs j) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "insert into jobs(title, description, category, status, location) values(?,?,?,?,?)";
            ps = con.prepareStatement(insert);
            ps.setString(1, j.getTitle());
            ps.setString(2, j.getDescription());
            ps.setString(3, j.getCategory());
            ps.setString(4, j.getStatus());
            ps.setString(5, j.getLocation());

            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                f = true;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    public List<Jobs> getAllJobs() {
        List<Jobs> list = new ArrayList<>();
        try {
            con=JdbcUtil.getJdbcConnection();
            String sql = "select * from jobs order by id desc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Jobs j = new Jobs();
                j.setCategory(rs.getString("category"));
                j.setDescription(rs.getString("description"));
                j.setId(rs.getInt("id"));
                j.setLocation(rs.getString("location"));
                j.setPdate(rs.getTimestamp("pdate") + "");
                j.setStatus(rs.getString("status"));
                j.setTitle(rs.getString("title"));
                list.add(j);
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

    public List<Jobs> getAllJobsForUser() {
        List<Jobs> list = new ArrayList<>();

        try {
            con=JdbcUtil.getJdbcConnection();
            String sql = "select * from jobs where status=? order by id desc";
            ps = con.prepareStatement(sql);
            ps.setString(1, "Active");
            rs = ps.executeQuery();
            while (rs.next()) {
                Jobs j = new Jobs();
                j.setCategory(rs.getString("category"));
                j.setDescription(rs.getString("description"));
                j.setId(rs.getInt("id"));
                j.setLocation(rs.getString("location"));
                j.setPdate(rs.getTimestamp("pdate") + "");
                j.setStatus(rs.getString("status"));
                j.setTitle(rs.getString("title"));
                list.add(j);
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

    public Jobs getJobById(Integer id) {
        Jobs j = new Jobs();
        try {
            con=JdbcUtil.getJdbcConnection();
            String sql = "select * from jobs where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                j.setCategory(rs.getString("category"));
                j.setDescription(rs.getString("description"));
                j.setId(rs.getInt("id"));
                j.setLocation(rs.getString("location"));
                j.setPdate(rs.getTimestamp("pdate") + "");
                j.setStatus(rs.getString("status"));
                j.setTitle(rs.getString("title"));

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
        return j;
    }

    public boolean updateJob(Jobs j) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String insert = "update jobs set title=?, description=?, category=?, status=?, location=? where id = ?";
            ps = con.prepareStatement(insert);
            ps.setString(1, j.getTitle());
            ps.setString(2, j.getDescription());
            ps.setString(3, j.getCategory());
            ps.setString(4, j.getStatus());
            ps.setString(5, j.getLocation());
            ps.setInt(6, j.getId());
            Integer roll = ps.executeUpdate();
            if (roll == 1) {
                f = true;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                JdbcUtil.cleanUp(con, ps, rs);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return f;
    }

    public boolean deleteJobs(Integer id) {
        boolean f = false;
        try {
            con=JdbcUtil.getJdbcConnection();
            String delete = "delete from jobs where id =?";
            ps = con.prepareStatement(delete);
            ps.setInt(1, id);
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

    public List<Jobs> getJobsOrLocationAndCategory(String category, String location) {
        List<Jobs> list = new ArrayList<>();
        Jobs j = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String sql = "select * from jobs where category=? or location=? order by id desc";
            ps = con.prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2, location);
            rs = ps.executeQuery();
            while (rs.next()) {
                j = new Jobs();
                j.setCategory(rs.getString("category"));
                j.setDescription(rs.getString("description"));
                j.setId(rs.getInt("id"));
                j.setLocation(rs.getString("location"));
                j.setPdate(rs.getTimestamp("pdate") + "");
                j.setStatus(rs.getString("status"));
                j.setTitle(rs.getString("title"));
                list.add(j);
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

    public List<Jobs> getJobsAndLocationAndCategory(String category, String location) {
        List<Jobs> list = new ArrayList<>();
        Jobs j = null;
        try {
            con=JdbcUtil.getJdbcConnection();
            String sql = "select * from jobs where category=? and location=? order by id desc";
            ps = con.prepareStatement(sql);
            ps.setString(1, category);
            ps.setString(2, location);
            rs = ps.executeQuery();
            while (rs.next()) {
                j = new Jobs();
                j.setCategory(rs.getString("category"));
                j.setDescription(rs.getString("description"));
                j.setId(rs.getInt("id"));
                j.setLocation(rs.getString("location"));
                j.setPdate(rs.getTimestamp("pdate") + "");
                j.setStatus(rs.getString("status"));
                j.setTitle(rs.getString("title"));
                list.add(j);
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
