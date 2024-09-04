use courier_tracking;

CREATE TABLE Parcel (
    parcel_id INT AUTO_INCREMENT PRIMARY KEY,
    tracking_number VARCHAR(50) NOT NULL UNIQUE,
    sender_name VARCHAR(100),
    sender_address TEXT,
    recipient_name VARCHAR(100),
    recipient_address TEXT,
    current_status VARCHAR(50),
    delivery_history TEXT
);


CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(15)
);


    INSERT INTO Customer (customer_id,customer_name, email, phone_number)
VALUES 
    (1,'Sana Ali', 'sana.ali@1.com', '1234567890'),
    (2,'Faiz', 'faiz1@.com', '2345678901'),
    (3,'Honey Singh', 'honey.singh@2.com', '3456789012'),
    (4,'Raftaar', 'raftaar@6.com', '4567890123'),
    (5,'Virat Kohli', 'vk@234.com', '5678901234');
    
    select *from Customer;
    
    INSERT INTO Parcel (tracking_number, sender_name, sender_address, recipient_name, recipient_address, current_status, delivery_history)
VALUES 
    ('TN001', 'Sana Ali', '123 Elm St', 'Faiz', 'Park St', 'Shipped', 'Dispatched from warehouse'),
    ('TN002', 'Faiz', '789 Maple Ave', 'Sana Ali', 'Lake Town', 'In Transit', 'In transit to local hub'),
    ('TN003', 'Honey Singh', '112 Birch Ln', 'Raftaar', 'Somewhere on the earth', 'Delivered', 'Delivered to recipient'),
    ('TN004', 'Raftaar', '345 Spruce St', 'Honey Singh', 'A place you dont want to go', 'Pending', 'Awaiting pickup'),
    ('TN005', 'Virat kohli', '678 Willow Dr', 'Anushka Sharma', '789 Rd', 'Returned', 'Returned to sender');

select *from Parcel;
    



