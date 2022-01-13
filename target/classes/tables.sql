create table RAW_REPORT(
DATE VARCHAR(100) NOT NULL,
IMPRESSIONS VARCHAR(100) NOT NULL,
CLICKS VARCHAR(40) NOT NULL,
EARNING VARCHAR(40) NOT NULL
);

DROP TABLE USER IF EXISTS;

DROP TABLE USER_STATS IF EXISTS;

CREATE TABLE USER(
firstName varchar(30),
middleName varchar(35),
lastName varchar(30),
city varchar(20),
id integer
);

CREATE TABLE USER_STATS(
firstName varchar(30),
lastName varchar(30),
city varchar(20),
id integer,
createTime timestamp default 'now'
);

INSERT INTO USER VALUES('Ram','Gopal', 'Verma', 'Mumbai', 44);
INSERT INTO USER VALUES('Harivansh','Rai', 'Bachhan', 'Patna', 84);
INSERT INTO USER VALUES('Mary','Anna', 'McBeth', 'Delhi', 92);
