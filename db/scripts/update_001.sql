-- It is used for integration test. Этот скрипт запускает Liquibase.
create table if not exists items (
   id serial primary key not null,
   name varchar(2000)
);