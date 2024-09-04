# Courier-Tracking-System-CTS-36
The Courier Tracking System is a Java-based application that manages and tracks parcel deliveries. It allows users to register new customers, update parcel statuses, and view parcel details using tracking numbers. The system integrates with a MySQL database to store and retrieve customer and parcel information.

## Features

- Track parcels by tracking number
- Register new customers
- View customer details
- Update parcel statuses and delivery history

## Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- NetBeans IDE (optional, for development)

### Database Setup

1. **Create the Database:**

   ```sql
   CREATE DATABASE courier_tracking;
   ```

2. **Create Tables:**

   Execute the following SQL scripts in your MySQL database to create the `Customer` and `Parcel` tables.

   ```sql
   CREATE TABLE Customer (
       customer_id INT AUTO_INCREMENT PRIMARY KEY,
       customer_name VARCHAR(100),
       email VARCHAR(100) UNIQUE,
       phone_number VARCHAR(15)
   );
   ```

   ```sql
   CREATE TABLE Parcel (
       parcel_id VARCHAR(50) PRIMARY KEY,
       tracking_number VARCHAR(50) NOT NULL UNIQUE,
       sender_name VARCHAR(100),
       sender_address TEXT,
       recipient_name VARCHAR(100),
       recipient_address TEXT,
       current_status VARCHAR(50),
       delivery_history TEXT
   );
  

### Application Configuration

1. **Database Connection:**

   Update the `DatabaseConnection` class in your project with your MySQL database credentials. Ensure the `url`, `user`, and `pass` fields match your MySQL setup.

   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/courier_tracking";
   private static final String USER = "root";
   private static final String PASS = "your_password";
   ```

### Running the Application

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/courier-tracking-system.git
   ```

2. **Navigate to the Project Directory:**

   ```bash
   cd courier-tracking-system
   ```

3. **Compile and Run:**

   - Open the project in IntelliJ IDE or your preferred IDE.
   - Build and run the project.

## Usage

- **Track Parcel:** Enter the tracking number to view parcel details.
- **Register Customer:** Add new customers to the system.
- **View Customer Details:** Retrieve information about a customer by their ID.
- **Update Parcel:** Modify the status and delivery history of an existing parcel.



