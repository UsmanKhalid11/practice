create database test;
use test;
create table  employee(
    id int not null ,
    name varchar(25) default null,
    designation varchar(25) default null,
    joining_date datetime default now(),
    primary key (id)
);