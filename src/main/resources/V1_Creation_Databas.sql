create table author
(
    id        BIGSERIAL PRIMARY KEY,
    name      varchar(50),
    last_name varchar(50)
);

create table news
(
    id           BIGSERIAL PRIMARY KEY,
    title        varchar(50),
    short_text   varchar(100),
    full_text    varchar(1000),
    published_in date default current_date,
    created_in   date default current_date,
    author_id    bigint references author (id) on delete set null
);

create table tag
(
    id      BIGSERIAL PRIMARY KEY,
    name    varchar(50),
    news_id bigint references news (id)  on delete set null
);

CREATE TABLE users
(
    id        BIGSERIAL PRIMARY KEY,
    name      varchar(50),
    last_name varchar(50),
    login     varchar(255),
    password  varchar(255),
    email     varchar(50),
    role      varchar(50)
);

CREATE TABLE role
(
    id   bigint references users (id)  on delete set null ,
    role varchar(50)
);