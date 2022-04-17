CREATE TABLE PERSON (
                         id   INTEGER NOT NULL AUTO_INCREMENT,
                         surname VARCHAR (256),
                         name VARCHAR(256),
                         patronymic VARCHAR (256),
                         full_name VARCHAR (256),
                         login VARCHAR (256),
                         password VARCHAR (256),
                         birthday DATE,
                         enable BIT,
                         PRIMARY KEY (id)
);

CREATE TABLE ACCOUNT (
                        id   INTEGER NOT NULL AUTO_INCREMENT,
                        person_id INTEGER,
                        type VARCHAR(256),
                        balance DECIMAL,
                        PRIMARY KEY (id)
);
