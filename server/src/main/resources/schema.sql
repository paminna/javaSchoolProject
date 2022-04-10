CREATE TABLE PERSON (
                         id   INTEGER NOT NULL AUTO_INCREMENT,
                         person_id VARCHAR (256),
                         surname VARCHAR (256),
                         name VARCHAR(256),
                         patronymic VARCHAR (256),
                         full_name VARCHAR (256),
                         birthday DATE,
                         account_id INTEGER,
                         PRIMARY KEY (id)
);

CREATE TABLE ACCOUNT (
                        id   INTEGER NOT NULL AUTO_INCREMENT,
                        account_id VARCHAR (256),
                        person_id INTEGER,
                        balance_id INTEGER,
                        PRIMARY KEY (id)
);

CREATE TABLE BALANCE(
                        id   INTEGER NOT NULL AUTO_INCREMENT,
                        type VARCHAR(256),
                        balance DECIMAL,
                        account_id INTEGER,
                        PRIMARY KEY (id)
)
