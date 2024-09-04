/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package couriertracking;

/**
 *
 * @author hp
 */

import java.sql.*;
public class databaseconection {
    private static final String url="jdbc:mysql://localhost:3306/courier_tracking";
    private static final String user="root";
    private static final String pass="Shauzi786";
    
    
//    method to get database connection
    
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            
        }
        catch(ClassNotFoundException e){
            System.out.println("MySql JDBC Driver not found.");
            e.printStackTrace();
        }
        catch(SQLException e){
            System.out.println("Connection failed.");
        }
        
        return con;
        
    }

}
