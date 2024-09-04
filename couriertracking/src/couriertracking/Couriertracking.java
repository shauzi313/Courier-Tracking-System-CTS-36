/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package couriertracking;

/**
 *
 * @author hp
 */
import java.sql.*;
import java.util.Scanner;

public class Couriertracking {

    /**
     * @param args the command line arguments
     */
    
//    private static final String url="jdbc:mysql://localhost:3306/courier_tracking";
//    private static final String user="root";
//    private static final String pass="Shauzi786";
//    
//    
////    method to get database connection
//    
//    public static Connection getConnection(){
//        Connection con=null;
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con=DriverManager.getConnection(url,user,pass);
//            
//        }
//        catch(ClassNotFoundException e){
//            System.out.println("MySql JDBC Driver not found.");
//            e.printStackTrace();
//        }
//        catch(SQLException e){
//            System.out.println("Connection failed.");
//        }
//        
//        return con;
//        
//    }
    
    public static void trackParcel(String trackingNumber)throws parcelNotFoundException{
        
        Connection con=databaseconection.getConnection();
        try{
            String query="SELECT *FROM Parcel WHERE tracking_number=?";
            PreparedStatement pps=con.prepareStatement(query);
            pps.setString(1,trackingNumber);
            ResultSet res=pps.executeQuery();
            
            if(res.next()){
                System.out.println("*****************************************************");
                System.out.println("Parcel ID:"+" "+res.getInt("parcel_id"));
                System.out.println("Sender Name:"+" "+res.getString("sender_name"));
                System.out.println("Recipient Name:"+" "+res.getString("recipient_name"));
                System.out.println("Current Status: " + res.getString("current_status"));
                System.out.println("Delivery History: " + res.getString("delivery_history"));
                System.out.println("*****************************************************");
              
            }
            else{
                
                throw new parcelNotFoundException("No parcel found with tracking number: " + trackingNumber);
                
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        } finally{
            try{
                con.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void registerCustomer(String name, String email, String phoneNumber) {
        Connection connection = databaseconection.getConnection();
        try {
            String query = "INSERT INTO Customer (customer_name, email, phone_number) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phoneNumber);
            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                
                System.out.println("*****************************************************");
                System.out.println("Customer registered successfully.");
                System.out.println("*****************************************************");
            } else {
                
                System.out.println("*****************************************************");
                System.out.println("Failed to register customer.");
                System.out.println("*****************************************************");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Method to Register a New Parcel
public static void registerParcel(String trackingNumber, String senderName, String senderAddress,
                                  String recipientName, String recipientAddress, String currentStatus,
                                  String deliveryHistory) {
    Connection connection = databaseconection.getConnection();
    try {
        String query = "INSERT INTO Parcel (tracking_number, sender_name, sender_address, recipient_name, recipient_address, current_status, delivery_history) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, trackingNumber);
        preparedStatement.setString(2, senderName);
        preparedStatement.setString(3, senderAddress);
        preparedStatement.setString(4, recipientName);
        preparedStatement.setString(5, recipientAddress);
        preparedStatement.setString(6, currentStatus);
        preparedStatement.setString(7, deliveryHistory);
        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("*****************************************************");
            System.out.println("Parcel registered successfully.");
            System.out.println("*****************************************************");
        } else {
            System.out.println("*****************************************************");
            System.out.println("Failed to register parcel.");
            System.out.println("*****************************************************");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
// Method to Update Parcel Status and Delivery History
public static void updateParcel(int parcelId, String currentStatus, String deliveryHistory) {
    Connection connection = databaseconection.getConnection();
    try {
        String query = "UPDATE Parcel SET current_status = ?, delivery_history = ? WHERE parcel_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, currentStatus);
        preparedStatement.setString(2, deliveryHistory);
        preparedStatement.setInt(3, parcelId);
        int result = preparedStatement.executeUpdate();

        if (result > 0) {
            System.out.println("*****************************************************");
            System.out.println("Parcel updated successfully.");
            System.out.println("*****************************************************");
        } else {
            System.out.println("*****************************************************");
            System.out.println("Failed to update parcel.");
            System.out.println("*****************************************************");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    
public static void viewCustomer(int customerId) throws CustomerNotFoundException{
        Connection connection = databaseconection.getConnection();
        try {
            String query = "SELECT * FROM Customer WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                System.out.println("*****************************************************");
                System.out.println("Customer ID: " + resultSet.getInt("customer_id"));
                System.out.println("Customer Name: " + resultSet.getString("customer_name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                System.out.println("*****************************************************");
            } else {
                throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    
    
    public static void main(String[]args){
        
         Scanner sc=new Scanner(System.in);
         int choice;
         
         do {
            System.out.println("===== Courier Tracking System =====");
            System.out.println("1. Parcel Tracking");
            System.out.println("2. Customer Information Management");
            System.out.println("3. Register New Parcel");
            System.out.println("4. Update Existing Parcel");
            System.out.println("0. Exit");
            System.out.println("===== Courier Tracking System =====");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine();
            
            try{
            switch (choice) {
                case 1:
                    System.out.print("Enter tracking number: ");
                    String trackingNumber = sc.nextLine();
                    trackParcel(trackingNumber);
                    break;
                    
             case 2:
                    System.out.println("1. Register New Customer");
                    System.out.println("2. View Customer Details");
                    System.out.print("Enter your choice: ");
                    int customerChoice = sc.nextInt();
                    sc.nextLine();
                    
             if (customerChoice == 1) {
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter phone number: ");
                        String phoneNumber = sc.nextLine();
                        registerCustomer(name, email, phoneNumber);
                    } else if (customerChoice == 2) {
                        System.out.print("Enter customer ID: ");
                        int customerId = sc.nextInt();
                        viewCustomer(customerId);
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;
               case 3:
                    System.out.print("Enter tracking number: ");
                    String tNumber = sc.nextLine();
                    System.out.print("Enter sender name: ");
                    String senderName = sc.nextLine();
                    System.out.print("Enter sender address: ");
                    String senderAddress = sc.nextLine();
                    System.out.print("Enter recipient name: ");
                    String recipientName = sc.nextLine();
                    System.out.print("Enter recipient address: ");
                    String recipientAddress = sc.nextLine();
                    System.out.print("Enter current status: ");
                    String currentStatus = sc.nextLine();
                    System.out.print("Enter delivery history: ");
                    String deliveryHistory = sc.nextLine();
                    registerParcel(tNumber, senderName, senderAddress, recipientName, recipientAddress, currentStatus, deliveryHistory);
                    break;
                    
               case 4:
                    System.out.print("Enter parcel ID : ");
                    int parcelId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new current status: ");
                    String newStatus = sc.nextLine();
                    System.out.print("Enter new delivery history: ");
                    String newHistory = sc.nextLine();
                    updateParcel(parcelId, newStatus, newHistory);
                    break;
                    
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
         }catch(parcelNotFoundException| CustomerNotFoundException e){
             System.out.println("Error: " + e.getMessage());
         }
        } while (choice != 0);

        sc.close();
                 
         
        }
        
       
    }
    
    

