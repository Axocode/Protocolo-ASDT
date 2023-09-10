drop database if exists usuarios;
create database usuarios;
use usuarios;

create table users(
iusernum int AUTO_INCREMENT primary key not null,
iuser varchar ( 50 ) ,
ipassword varchar (  50  )
);