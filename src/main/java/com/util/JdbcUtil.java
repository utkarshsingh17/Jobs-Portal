/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author kali
 */
public class JdbcUtil {

    private static HikariDataSource dataSource;
    private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("org.postgresql.Driver");
              String loc="/home/kali/Downloads/Job-Portal/src/main/resources/application.properties";          
        HikariConfig config = new HikariConfig(loc);
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/techblog");  // Replace with your database URL
//        config.setUsername("postgres");  // Replace with your database username
//        config.setPassword("admin");  // Replace with your database password
        config.setMaximumPoolSize(20);  // Set the max pool size based on your needs
        config.setIdleTimeout(30000);  // Timeout for idle connections
        config.setMaxLifetime(1800000);  // Maximum connection lifetime
        config.setConnectionTimeout(30000);  // Timeout for getting a connection from the pool
        
        dataSource = new HikariDataSource(config);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

    public static Connection getJdbcConnection(){
       	// Take the data from properties file
        Connection connection =null;
        try{

                 connection=dataSource.getConnection();
		System.out.println("CONNECTION object created...");
        }catch(Exception e){
            e.printStackTrace();
            
        }
		return connection;
    }
    public static void cleanUp(Connection con, Statement statement, ResultSet resultSet) throws SQLException {
		// Step6. Close the resources
		if (con != null) {
			con.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}
