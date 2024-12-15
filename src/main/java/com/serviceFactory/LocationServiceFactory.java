/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serviceFactory;

import com.service.ILocationService;
import com.service.LocationServiceImpl;

/**
 *
 * @author kali
 */
public class LocationServiceFactory {
       private LocationServiceFactory(){
        
    }
    private static ILocationService locationService=null;
    public static ILocationService getLocationService(){
        if(locationService==null){
            locationService=new LocationServiceImpl();
        }
        return locationService;
    }
}
