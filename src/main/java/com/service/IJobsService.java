/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dto.Jobs;
import java.util.List;

/**
 *
 * @author kali
 */
public interface IJobsService {
        public boolean addJobs(Jobs j);

    public List<Jobs> getAllJobs() ;
    public List<Jobs> getAllJobsForUser();

    public Jobs getJobById(Integer id);

    public boolean updateJob(Jobs j);

    public boolean deleteJobs(Integer id);

    public List<Jobs> getJobsOrLocationAndCategory(String category, String location);

    public List<Jobs> getJobsAndLocationAndCategory(String category, String location);
}
