-- Fill person table (id, surname, name, patronymic, fullname, birthday)
INSERT INTO PERSON VALUES (1, 'Ясеневский','Иван', 'Дмитриевич', 'Ясеневский Иван Дмитриевич', 'ivan', '1232', '1982-01-23', true);
INSERT INTO PERSON VALUES (2, 'Варюшина', 'Алена', 'Александровна', 'Варюшина Алена Александровна', 'alona', '1111', '1993-12-13', true);
INSERT INTO PERSON VALUES (3, 'Кузьменко', 'Дмитрий', 'Григорьевич', 'Кузьменко Дмитрий Григорьевич', 'dima', '1234', '1967-03-21', true);

--Fill accounts (Id, personId, type, balance)
INSERT INTO ACCOUNT VALUES (1, 1, 'rubles', 1231131.21);
INSERT INTO ACCOUNT VALUES (2, 1, 'euro', 1213.1);
INSERT INTO ACCOUNT VALUES (3, 2, 'rubles', 123113.123);