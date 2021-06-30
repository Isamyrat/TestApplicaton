create table USER
(
    ID            BIGINT auto_increment  primary key,
    NAME        VARCHAR(20) not null,
    EMAIL        VARCHAR(35) not null,
    PASSWORD VARCHAR(15) not null,
    role  VARCHAR(10),
    create_at timestamp not null
);
create table TAG
(
    ID   SMALLINT auto_increment
        primary key,
    NAME VARCHAR(100)
);
create table BRAND
(
    ID   INT auto_increment
        primary key,
    NAME VARCHAR(100)
);
create table BASKET
(
    ID            bigint auto_increment
        primary key,
    user_id BIGINT not null,
    foreign key (user_id) references User (ID)
);
create table DEVICE
(
    ID       BIGINT auto_increment
        primary key,
    NAME     VARCHAR(50) not null,
    YEAR     DATE        not null,
    COUNT    INT         not null,
    PRICE    DOUBLE      not null,
    TAG_ID   SMALLINT    not null
        references TAG (ID),
    BRAND_ID INT         not null
        references BRAND (ID)
);


create table Device_Information
  (
      ID            BIGINT auto_increment
          primary key,
      name        VARCHAR(150) not null,
      description        VARCHAR(150) not null,
      device_id BIGINT not null,
      foreign key (device_id) references DEVICE (ID)

);
create table BASKET_DEVICE
(
    ID            BIGINT auto_increment
        primary key,
    device_id BIGINT not null,
    BASKET_id BIGINT not null,
    foreign key (device_id) references DEVICE (ID),
    foreign key (BASKET_id) references BASKET (ID)
);