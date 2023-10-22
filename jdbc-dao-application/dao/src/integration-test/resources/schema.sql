
create table if not exists model_type (
	id int2 generated always as identity primary key,
	name varchar(50) unique not null
);

insert into model_type (name) values
('BMW M5'),
('Chevrolet Camaro'),
('Toyota Alphard'),
('Mazda RX-8'),
('Suzuki Ninja'),
('Volgswagen Transporter'),
('Honda CBR'),
('Audi A4'),
('Ford Focus'),
('Mercedes Transporter');

create table if not exists transport_type (
	id int2 generated always as identity primary key,
	name varchar(50) unique not null
);

insert into transport_type (name) values
('automobile'),
('motorbike'),
('minibus');

create table if not exists client (
	id int4 generated always as identity primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null
);

insert into client (first_name, last_name) values
('Optimus','Prime'),
('Ethan','Hunt'),
('Rocky','Balboa'),
('Forrest','Gump'),
('Travis','Bickle'),
('john','McCane'),
('Jefrey','Lebowski'),
('Tyler','Durden'),
('John','Connor'),
('Bruce','Wayne');

create table if not exists transport (
	id int4 generated always as identity primary key,
	model_type_id int2 not null,
	transport_type_id int2 not null,
	client_id int4,

	constraint fk_transport_model_type_id foreign key (model_type_id) references model_type(id),
	constraint fk_transport_transport_type_id foreign key (transport_type_id) references transport_type(id),
	constraint fk_transport_client_id foreign key (client_id) references client(id)
);

insert into transport (model_type_id, transport_type_id, client_id) values
(1, 1, 10),
(2, 1, 9),
(3, 3, 8),
(4, 1, 7),
(5, 2, 6),
(6, 3, 5),
(7, 2, 4),
(8, 1, 3),
(9, 1, 2),
(10, 2, 1);

select tr.id, mt."name" as modelName, tt."name" as transportType, cl.first_name as firstName, cl.last_name as lastName  from transport tr 
	left join model_type mt on tr.model_type_id = mt.id
	left join transport_type tt on tr.transport_type_id = tt.id 
	left join client cl on tr.client_id = cl.id ;