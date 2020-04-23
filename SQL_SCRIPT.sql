SET GLOBAL time_zone = '-1:00';

create database PhoneShopDB;
use PhoneShopDB;

create table Products (
	ID int NOT NULL AUTO_INCREMENT,
	Product varchar(255),
	Price double,
	PRIMARY KEY (ID)
);

create table Users (
	UserID int NOT NULL AUTO_INCREMENT,
	FName varchar(255),
	LName varchar(255),
	PRIMARY KEY (UserID)
);

create table Orders (
	OrderID int NOT NULL AUTO_INCREMENT,
	ProductID int,
	dte_tme varchar(255),
	PRIMARY KEY (OrderID)
);

insert into Products (ID, Product, Price) 
values (1, 'Apple iPhone 11 Pro', 999);

insert into Products (ID, Product, Price) 
values (2, 'Apple iPhone 11 Pro Max', 1199);

insert into Products (ID, Product, Price) 
values (3, 'Samsung Galaxy S20 Ultra', 1199);

insert into Products (ID, Product, Price) 
values (4, 'Samsung Galaxy Note10+', 1099);

insert into Products (ID, Product, Price) 
values (5, 'OnePlus 8 Pro', 899);

select * from Products;