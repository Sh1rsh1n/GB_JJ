drop schema if exists school_db cascade ;

create schema school_db;

CREATE TABLE school_db.courses (
    id serial,
    title varchar(100) not null,
    duration int default(40),
    primary key (id)
);

INSERT INTO school_db.courses
    (title, duration) VALUES
    ('Математика', 30),
    ('Информатика', 50),
    ('Логика', 30),
    ('Алгоритмы', 25);







