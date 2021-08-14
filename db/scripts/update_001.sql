-- It is used for integration test. Этот скрипт запускает Liquibase.
CREATE TABLE IF NOT EXISTS items
(
    id      serial PRIMARY KEY,
    name    text,
    created timestamp
);