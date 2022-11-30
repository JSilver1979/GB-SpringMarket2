create table if not exists students (id bigserial primary key, student_name varchar(255), score int);
insert into students (student_name, score) values ('Bob', 100), ('Jack', 80), ('John', 90);