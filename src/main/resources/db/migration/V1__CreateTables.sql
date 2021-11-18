CREATE TABLE USER ( id BIGINT PRIMARY KEY auto_increment, NAME VARCHAR ( 100 ) );

CREATE TABLE `match` ( id BIGINT PRIMARY KEY auto_increment, user_id BIGINT, score INT );

insert into user(id,name) values(1,"AAA");
insert into user(id,name) values(2,"BBB");
insert into user(id,name) values(3,"CCC");
insert into user(id,name) values(4,"DDD");

insert into `match`(id,user_id,score) values(1,1,1000);
insert into `match`(id,user_id,score) values(2,2,2000);
insert into `match`(id,user_id,score) values(3,3,3000);
insert into `match`(id,user_id,score) values(4,4,400);
insert into `match`(id,user_id,score) values(5,2,5000);