create table if not exists users
(
    id         bigserial primary key,
    username   varchar(30) not null,
    password   varchar(80) not null
);

create table if not exists roles
(
    id         bigserial primary key,
    name       varchar(50) not null
);

create table if not exists users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password)
values ('user', '$2a$12$WohW.kyCzm2A8h4MOZgK4uS3zTjLk/9oTB/NMKNsxxS8PwKHPODjW'),
       ('admin', '$2a$12$y33n.zvHmKdSgz5noyKIwuosBBBvwYlgpFUfGpHgKkz1gw.MuHpzG');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);