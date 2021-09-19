SET MODE PostgresSQL;

CREATE TABLE IF NOT EXISTS animals (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
)
CREATE TABLE IF NOT EXISTS sightings (
    id int,
    location VARCHAR,
    rangerName VARCHAR,
)