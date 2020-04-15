create database if not exists ims;
create table if not exists ims.customers(customerid int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(itemid int primary key auto_increment, itemName varchar(40), itemPrice DOUBLE(6,2));
create table if not exists ims.orders(orderid int primary key auto_increment, totalPrice DOUBLE(10,2), customerid int, FOREIGN KEY (customerid) REFERENCES customers(customerid));