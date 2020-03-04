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
    creation_datetime datetime not null,
    constraint USER_ROLES_pk
        primary key (id),
    constraint USER_ROLES_USERS_user_name_fk
        foreign key (user_name) references USERS (user_name)
            on update cascade on delete cascade
);

create unique index USER_ROLES_user_name_uindex
    on USER_ROLES (user_name);

#####################################################

# Create the MENU_APIS table

create table MENU_APIS
(
    id int not null,
    name varchar(255) not null,
    creation_datetime datetime not null,
    constraint MENU_APIS_pk
        primary key (id)
);


#####################################################

# Create the RESTAURANTS table

create table RESTAURANTS
(
    id int not null,
    name varchar(255) null,
    source_api int null,
    api_id int null,
    creation_datetime datetime not null,
    constraint RESTAURANTS_pk
        primary key (id),
    constraint RESTAURANTS_MENU_APIS_id_fk
        foreign key (source_api) references MENU_APIS (id)
            on update cascade on delete set null
);
create unique index RESTAURANTS_api_id_uindex
    on RESTAURANTS (api_id);

#####################################################

# Create the MENU_ITEMS table

create table MENU_ITEMS
(
    id int not null,
    name varchar(255) null,
    source_api int null,
    api_id int null,
    parent_restaurant_api_id int null,
    creation_datetime datetime not null,
    constraint MENU_ITEMS_pk
        primary key (id),
    constraint MENU_ITEMS_MENU_APIS_id_fk
        foreign key (source_api) references MENU_APIS (id)
            on update cascade on delete set null,
    constraint MENU_ITEMS_RESTAURANTS_id_fk
        foreign key (parent_restaurant_api_id) references RESTAURANTS (id)
            on update cascade on delete set null
);

#####################################################

# Create the USER_FAVORITES table

create table USER_FAVORITES
(
    id int auto_increment,
    user_id int not null,
    favorites_line int null,
    menu_item_id int not null,
    constraint USER_FAVORITES_pk
        primary key (id),
    constraint USER_FAVORITES_USERS_id_fk
        foreign key (user_id) references USERS (id)
            on update cascade on delete cascade,
    constraint USER_FAVORITES_MENU_ITEMS_id_fk
        foreign key (menu_item_id) references MENU_ITEMS (id)
            on update cascade on delete cascade

);

#####################################################

# Create the OUTCOMES table

create table OUTCOMES
(
    id int not null,
    name varchar(255) not null,
    creation_datetime datetime not null,
    constraint OUTCOMES_pk
        primary key (id)
);



#####################################################

# Create the CARBOHYDRATE_ESTIMATES table

create table CARBOHYDRATE_ESTIMATES
(
    id int not null,
    menu_item_id int not null,
    grams_carbohydrate_estimate int not null,
    outcome_id int null,
    user_id int null,
    creation_datetime datetime not null,
    update_datetime datetime not null,
    constraint CARBOHYDRATES_pk
        primary key (id),
    constraint CARBOHYDRATES_MENU_ITEMS_id_fk
        foreign key (menu_item_id) references MENU_ITEMS (id)
            on update cascade on delete cascade,
    constraint CARBOHYDRATES_USERS_id_fk
        foreign key (user_id) references USERS (id)
            on update cascade on delete set null,
    constraint CARBOHYDRATE_ESTIMATES_OUTCOMES_id_fk
        foreign key (outcome_id) references OUTCOMES (id)
            on update cascade on delete set null
);