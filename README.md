# javaSchoolProject
Модель получения клиентом баланса по карте на банкоматом. 
В качестве системы сборки используется Maven. 
Приложение состоит из 2 модулей - клиент и сервер.
Приложение с ролью сервер хранит свои данные в базе данных H2.
Для взаимодействия модули используют RestTemplate.
Модули покрыты JUnit тестами.


Получение баланса по картам по логину и паролю

http://localhost:8080/client/get/accounts/by/логин/пароль

Конвертация рублей в другие валюты

http://localhost:8080/client/convert/из_какой_валюты_переводим/в_какую_валюту_переводим/by/логин

