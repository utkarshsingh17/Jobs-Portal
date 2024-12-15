/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.IJobsDao;
import com.dao.JobsDaoImpl;

/**
 *
 * @author kali
 */
public class JobsDaoFactory {
      private JobsDaoFactory(){
        
    }
    private static IJobsDao jobsDao=null;
    public static IJobsDao getJobsDao(){
        if(jobsDao==null){
            jobsDao=new JobsDaoImpl();
        }
        return jobsDao;
    }
}
