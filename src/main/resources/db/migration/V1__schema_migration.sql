drop table if exists STUDENT;

CREATE TABLE STUDENT
(
    ID             BIGSERIAL        PRIMARY KEY,
    NAME           VARCHAR(255)     NOT NULL,
    AGE           INT     NOT NULL
);