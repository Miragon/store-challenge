create table articles
(
    price       double precision not null,
    id          uuid             not null
        primary key,
    description varchar(255)     not null,
    name        varchar(255)     not null
);

alter table articles
    owner to "${flyway:user}";

create table cart
(
    user_id varchar(255) not null
        primary key
);

alter table cart
    owner to "${flyway:user}";

create table cart_items
(
    price_per_item double precision not null,
    quantity       integer          not null,
    article_id     uuid             not null,
    id             uuid             not null
        primary key,
    user_id        varchar(255)     not null
        constraint fkh4ffcvpjpppmpiykmw128ysks
            references cart
);

alter table cart_items
    owner to "${flyway:user}";

create table order_items
(
    price_per_item double precision not null,
    quantity       integer          not null,
    article_id     uuid             not null,
    id             uuid             not null
        primary key,
    order_id       uuid             not null,
    article_name   varchar(255)     not null
);

alter table order_items
    owner to "${flyway:user}";

create table orders
(
    total_amount double precision not null,
    order_date   timestamp(6)     not null,
    id           uuid             not null
        primary key,
    status       varchar(255)     not null,
    user_id      varchar(255)     not null
);

alter table orders
    owner to "${flyway:user}";

