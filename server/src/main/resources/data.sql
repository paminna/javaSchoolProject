-- Fill person table (id, surname, name, patronymic, fullname, birthday)
INSERT INTO PERSON VALUES (1, 'Ясеневский','Иван', 'Дмитриевич', 'Ясеневский Иван Дмитриевич', '1982-01-23', 'ivan', '1111');
INSERT INTO PERSON VALUES (2, 'Варюшина', 'Алена', 'Александровна', 'Варюшина Алена Александровна', '1993-12-13', 'alena', '2222');
INSERT INTO PERSON VALUES (3, 'Кузьменко', 'Дмитрий', 'Григорьевич', 'Кузьменко Дмитрий Григорьевич', '1967-03-21', 'dima', '1234');

--Fill accounts (Id, personId, type, balance)
INSERT INTO ACCOUNT VALUES (1, 1, 'rubles', 1231131.21);
INSERT INTO ACCOUNT VALUES (2, 1, 'euro', 1213.1);
INSERT INTO ACCOUNT VALUES (3, 2, 'rubles', 123113.123);
INSERT INTO ACCOUNT VALUES (4, 3, 'rubles', 76564534232.234);