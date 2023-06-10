CREATE TABLE Users
(
 name varchar(100) NOT NULL,
  email varchar(30) NOT NULL ,
  dob date DEFAULT NULL,
 createdAt date DEFAULT NULL,
 updatedAt date DEFAULT NULL,
 address varchar(300),
 gender  Enum('Male','Female'),
 password varchar(500) NOT NULL,
 PRIMARY KEY (email)
);