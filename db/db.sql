create table quarkus-social;
CREATE TABLE USERS(
	id bigserial not null primary key,
	name varchar(100) not null,
	age INTEGER not null
);