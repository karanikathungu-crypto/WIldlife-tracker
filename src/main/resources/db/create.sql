SET MODE PostgresSQL;
CREATE DATABASE wildlife;
\c wildlife;
CREATE TABLE if NOT EXISTS animals (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    location VARCHAR,
    rangerName VARCHAR
);
CREATE TABLE if NOT EXISTS sightings (
    id int,
    location VARCHAR,
    rangerName VARCHAR
);