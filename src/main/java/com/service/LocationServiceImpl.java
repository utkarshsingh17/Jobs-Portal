/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dao.ILocationDao;
import com.daoFactory.LocationDaoFactory;
import com.dto.Location;
import java.util.List;

/**
 *
 * @author kali
 */
public class LocationServiceImpl implements ILocationService{
    ILocationDao locationDao=null;
      public List<Location> getAllLocation() {
          locationDao =LocationDaoFactory.getLocationDao();
          return locationDao.getAllLocation();
          
          
      }
}
