#Create USERS table
create table USERS
(
    id int auto_increment,
    first_name varchar(255) default NULL null,
    last_name varchar(255) default NULL null,
    user_name varchar(255) not null,
    email varchar(255) not null,
    creation_datetime datetime not null,
    update_datetime datetime not null,
    constraint USERS_pk
        primary key (id)
);

create unique index USERS_email_uindex
    on USERS (email);

create unique index USERS_user_name_uindex
    on USERS (user_name);

#####################################################

# Create the USER_ROLES table
create table USER_ROLES
(
    id int auto_increment,
    role_name varchar(255) null,
    user_name varchar(255) not null,
    created_at datetime not null,
    constraint USER_ROLES_pk
        primary key (id),
    constraint USER_ROLES_USERS_user_name_fk
        foreign key (user_name) references USERS (user_name)
            on update cascade on delete cascade
);

create unique index USER_ROLES_user_name_uindex
    on USER_ROLES (user_name);

