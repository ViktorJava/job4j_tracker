# Проект Tracker [<img alt="Logo" src="images/logo.png" height="80" align="right"/>](https://www.vectorlogo.zone)
> Учебный проект регистрации заявок..


[![Build Status](https://travis-ci.org/ViktorJava/job4j_tracker.svg?branch=master)](https://travis-ci.org/ViktorJava/job4j_tracker)
[![codecov](https://codecov.io/gh/ViktorJava/job4j_tracker/branch/master/graph/badge.svg)](https://codecov.io/gh/ViktorJava/job4j_tracker)

## Технологии и инструменты:
<p align="center">
<img src="https://www.vectorlogo.zone/logos/java/java-ar21.svg" alt="java" width="120" height="60"/>
<img src="images/idea.png" alt="intellij" height="50"/>
<img src="https://www.vectorlogo.zone/logos/github/github-ar21.svg" alt="github" height="70"/>
<img src="images/maven.png" alt="maven" height="30"/>
<img src="https://www.vectorlogo.zone/logos/travis-ci/travis-ci-ar21.svg" alt="Travis CI" width="120" height="60"/>
<img src="images/checkstyle.png" alt="CheckStyle"  height="40"/>
<img src="images/codecov.png" alt="Codecov"  height="35"/>
<img src="images/junit.png" alt="JUnit"  height="40"/>
<img src="images/postgresql.png" alt="PSQL"  height="45"/>
<img src="images/jcf.png" alt="JCF"  width="90"/>
<img src="images/liquibase.png" alt="liquibase" height="30"/>
<img src="images/h2.png" alt="liquibase" height="40"/>
</p>

На площадке **Tracker** отрабатываются технологии программирования, приобретаются практические навыки применения концепций и инструментов, проектирования и архитектуры.

## Проверка вашей установки Java
Для работы с любым программным обеспечением, написанным на **JAVA**, у вас должен быть установлен **Java SE Development Kit (JDK)**. Если у вас все настроено правильно, вы сможете открыть командное окно и выполнить следующие две команды:

`$ java -version`

`$ javac -version`

Обе команды должны завершиться успешно и сообщить об одной и той же версии **Java**.

## PostgreSQL


Необходимо создать базу данных **tracker**:

`$ psql --username=postgres` 

`$ create database tracker;`

и таблицу **items**:

`$ CREATE TABLE items(id serial PRIMARY KEY, name text );`

Конфигурация **PostgreSQL** (логин, пароль, драйвер, url) через `app.properties`.

## Компиляция и запуск
В проекте сконфигурировано 2 профиля, **test** и **production**.
Для тестов, прикручен [Liqubase](https://www.liquibase.org/) в связке с [СУБД H2](https://www.h2database.com/html/main.html). Используем **Maven.** 

Для запуска тестов, применяем:

`$ mvn test -Ptest`

Для сборки: 

`$ mvn install -Pproduction`

`$ java -jar target/tracker.jar`

## Лицензия
	
[MIT. Free Software!](https://github.com/ViktorJava/job4j/tree/master/LICENSE)

---

>e-mail:[gmail.com](mailto:gipsyscrew@gmail.com) &nbsp;&middot;&nbsp;
>fb:[Facebook.com](https://www.facebook.com/viktor.vdovichenko) &nbsp;&middot;&nbsp;
> GitHub:[@ViktorJava](https://github.com/ViktorJava) &nbsp;&middot;&nbsp;
> OK:[Odnoklassniki](https://ok.ru/profile/571539586668)

