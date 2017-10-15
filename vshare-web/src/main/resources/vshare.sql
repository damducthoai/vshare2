drop database if exists vshare;
create database vshare;
use vshare;

drop table if exists user;
create table user(
	user_id bigint(20) not null auto_increment,
    user_email varchar(255),
    user_name varchar(255),
    user_password varchar(255),
    primary key (user_id)
);
insert into user(user_email, user_password, user_name) values ('admin@gmail.com', 'admin', 'admin');
insert into user(user_email, user_password, user_name) values ('user@gmail.com', 'user', 'user');
drop table if exists authority;
create table authority (
	user_id bigint(20) not null,
    authority varchar(40) not null,
    primary key (user_id, authority),
    foreign key (user_id) references user(user_id)
);
insert into authority values(1, "admin");
insert into authority values(1, "ROLE_USER");
insert into authority values(2, "user");
insert into authority values(2, "ROLE_USER");