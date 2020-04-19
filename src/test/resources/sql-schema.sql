create database if not exists ims;
drop table if exists ims.customers;
drop table if exists ims.items;
drop table if exists ims.orders;
create table if not exists ims.customers(customerid int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(itemid int primary key auto_increment, itemname varchar(40), itemprice double(9,2));
create table if not exists ims.orders(orderid int primary key auto_increment, customerid int, foreign key (customerid) references customers(customerid), totalprice double (9,2));