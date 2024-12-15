/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.IJobsDao;
import com.daoFactory.JobsDaoFactory;
import com.dto.Jobs;
import java.util.List;

/**
 *
 * @author kali
 */
public class JobsServiceImpl implements IJobsService{
    IJobsDao jobsDao=null;
      @Override
      public boolean addJobs(Jobs j) {
          jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.addJobs(j);
          
  
    }
       @Override
    public List<Jobs> getAllJobs() {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.getAllJobs();
          

    }
 @Override
    public List<Jobs> getAllJobsForUser() {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.getAllJobsForUser();
          
    
    }
 @Override
    public Jobs getJobById(Integer id) {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.getJobById(id);
          
     
    }
 @Override
    public boolean updateJob(Jobs j) {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.updateJob(j);
          
     
    }
 @Override
    public boolean deleteJobs(Integer id) {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.deleteJobs(id);
          
     
    }
 @Override
    public List<Jobs> getJobsOrLocationAndCategory(String category, String location) {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.getJobsOrLocationAndCategory(category,location);
          
  
    }
 @Override
    public List<Jobs> getJobsAndLocationAndCategory(String category, String location) {
         jobsDao=JobsDaoFactory.getJobsDao();
          return jobsDao.getJobsAndLocationAndCategory(category ,location);
          

    }
    
}
