create table login(
username varchar(50) not null,
password varchar(50));

create table form(
formid varchar(50) not null,
city varchar(50),
name varchar(50),
email varchar(50),
subject varchar(50),
message varchar(50)
);


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 

insert into form values("formid","city","name","email","subject","message");
insert into form values("1","Bangalore","Maha","mahasensri@gmail.com","Subject","Description");
