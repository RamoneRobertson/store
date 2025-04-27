create table profiles
(
    id             bigint auto_increment
        primary key,
    bio            varchar(255)  null,
    phone_number   varchar(255)  not null,
    date_of_birth  date          not null,
    loyalty_points int default 0 null,
    user_id        bigint        not null,
    constraint profiles_users_id_fk
        foreign key (user_id) references users (id)
);