drop table if exists funcionarios;
create table funcionarios (
    id identity primary key
    ,data_cadastro timestamp not null
    ,matricula bigint not null
    ,nome varchar(25) not null
    ,cargo varchar(20) not null
    ,altura decimal(3,2) not null
    ,departamento_id bigint not null
);

drop table if exists departamentos;
create table departamentos (
    id identity primary key
    ,codigo bigint not null
    ,nome varchar(25) not null
);

alter table funcionarios add foreign key (departamento_id) references departamentos(id);


drop table if exists users;
create table users (
                       username varchar(50) not null primary key,
                       password varchar(500) not null,
                       enabled boolean not null
);

drop table if exists authorities;
create table authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null
);
alter table authorities add foreign key (username) references users(username);

