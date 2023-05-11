create table if not exists customer(
    id bigint primary key auto_increment not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    age smallint not null,
    address varchar(250) not null
);
create sequence customer_seq START WITH (select max(id) + 1 from customer);