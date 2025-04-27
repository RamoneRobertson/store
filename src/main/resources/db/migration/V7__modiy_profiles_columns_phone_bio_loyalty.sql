alter table profiles
    modify bio text null;

alter table profiles
    modify phone_number varchar(15) not null;

alter table profiles
    modify loyalty_points int UNSIGNED;