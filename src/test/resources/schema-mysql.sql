CREATE TABLE right_winger
(
    name VARCHAR(20),
    birthdate DATE,
    fullname VARCHAR(100),
    phrases VARCHAR(500),
    gender VARCHAR(10),
    picture BLOB,
    highlights VARCHAR(255),
    networth VARCHAR(255),
    bio VARCHAR(1000),
    PRIMARY KEY(name, birthdate)
);