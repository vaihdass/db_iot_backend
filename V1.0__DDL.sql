create sequence account_seq;

create table accounts (
	id int default nextval('account_seq'),
	name varchar(128),
	email varchar(128) not null,
	phone_number varchar(60) not null,
	password_hash varchar not null,
	password_salt varchar not null,
	
	constraint accounts_id_pk primary key(id),
	constraint accounts_email_uniq unique(email),
	constraint accounts_phone_number_uniq unique(phone_number),
	constraint accounts_length_check check(length(email) > 0 and length(phone_number) > 0 and length(password_hash) > 0 and length(password_salt) > 0),
	constraint accounts_regex_check check(phone_number ~ '^\+?[1-9][0-9]{7,14}$' and email ~ '^\S+@\S+\.\S+$')
);

create sequence hub_seq;

create table hubs (
	id int default nextval('hub_seq'),
	"name" varchar(255) not null,
	
	constraint hubs_id_pk primary key(id),
	constraint hubs_name_check check(length(name) > 0)
);

create sequence type_seq;

create table "types" (
	id int default nextval('type_seq'),
	"name" varchar(255) not null,
	description varchar (2000),
	
	constraint types_id_pk primary key(id),
	constraint types_name_check check(length(name) > 0)
);

create sequence sensor_seq;

create table sensors (
	id int default nextval('sensor_seq'),
	hub_sensor_id varchar(255) not null,
	hub_id int not null,
	"name" varchar(255) not null,
	type_id int not null,
	date_of_entry date not null,
	
	constraint sensors_id_pk primary key(id),
	constraint sensors_hub_id_fk foreign key(hub_id) references hubs,
	constraint sensors_type_id_fk foreign key(type_id) references "types",
	constraint sensors_name_hub_sensor_id_check check (length(name) > 0 and length(hub_sensor_id) > 0),
	constraint sensors_uniq unique(hub_id, hub_sensor_id)
);

create sequence sensor_log_seq;

create table sensor_logs(
	id int default nextval('sensor_log_seq'),
	sensor_id int not null,
	status int not null,
	message varchar(1000),
	"data" bytea,
	"time" timestamptz not null,
	
	constraint sensor_logs_id_pk primary key(id),
	constraint sensor_logs_sensor_id_fk foreign key(sensor_id) references sensors
);

create table account_hub (
	account_id int not null,
	hub_id int not null,
	
	constraint account_hub_pk primary key(account_id, hub_id),
	constraint user_hub_account_id_fk foreign key(account_id) references accounts,
	constraint account_hub_hub_id_fk foreign key(hub_id) references hubs
);

create sequence role_seq;

create table roles(
	id int default nextval('role_seq'),
	"name" varchar(128) not null,
	description varchar(2000),
	hub_id int not null,
	
	constraint roles_id_pk primary key(id),
	constraint roles_hub_id_fk foreign key(hub_id) references hubs,
	constraint roles_name_check check(length(name) > 0)
);

create sequence permission_seq;

create table permissions(
	id int default nextval('permission_seq'),
	type_id int,
	name varchar(255) not null,
	decription varchar(2000),
	
	constraint permissions_id_pk primary key(id),
	constraint permissions_type_id_pk foreign key(type_id) references "types",
	constraint permissions_name_check check(length(name) > 0)
);

create table role_permission (
	role_id int not null,
	permission_id int not null,
	
	constraint role_permission_pk primary key(role_id, permission_id),
	constraint role_permission_role_id_fk foreign key(role_id) references roles,
	constraint role_permission_permission_id_fk foreign key(permission_id) references permissions
);

create table account_hub_role(
	hub_id int not null,
	account_id int not null,
	role_id int not null,
	
	constraint account_hub_role_pk primary key(hub_id, account_id, role_id),
	constraint account_hub_role_uniq unique(account_id, hub_id),
	constraint account_hub_role_hub_id_pk foreign key(hub_id) references hubs,
	constraint account_hub_role_account_id_pk foreign key(account_id) references accounts,
	constraint account_hub_role_role_id_pk foreign key(role_id) references roles
);
