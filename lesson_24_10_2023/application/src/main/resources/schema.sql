create table person (
	id int2 generated always as identity primary key,
	name varchar(50) unique not null
);

insert into some_base (name) values  ('Kiryl'), ('Petr'), ('Alexandr'), ('Sergei');