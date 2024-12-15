/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.IJobsService;
import com.service.JobsServiceImpl;

/**
 *
 * @author kali
 */
public class JobsServiceFactory {
       private JobsServiceFactory(){
        
    }
    private static IJobsService jobsService=null;
    public static IJobsService getJobsService(){
        if(jobsService==null){
            jobsService=new JobsServiceImpl();
        }
        return jobsService;
    }
}
