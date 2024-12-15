/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daoFactory;

import com.dao.ILocationDao;
import com.dao.LocationDaoImpl;

/**
 *
 * @author kali
 */
public class LocationDaoFactory {
     private LocationDaoFactory(){
        
    }
    private static ILocationDao locationDao=null;
    public static ILocationDao getLocationDao(){
        if(locationDao==null){
            locationDao=new LocationDaoImpl();
        }
        return locationDao;
    }
}
