# Дипломный проект по тестированию интернет-магазина [Lamoda](https://www.lamoda.ru/)

## :open_book: Содержание:

- [Технологии, используемые в данном проекте](#gear-Технологии-используемые-в-данном-проекте)
- [Тест кейсы](#heavy_check_mark-Тест-кейсы)
- [Запуск тестов из терминала (локально)](#computer-запуск-тестов-из-терминала)
- [Запуск тестов в Jenkins](#-запуск-тестов-из-jenkins)
- [Allure отчет](#-allure)
- [Уведомления в Telegram](#-telegram)
- [Видео прохождения тестов]()
- [Интеграция с AllureTestOps]()

## :gear: Технологии, используемые в данном проекте

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="images/logo/GitHub.svg" width="50" height="50"  alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure_Report.svg" width="50" height="50"  alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="images\logo\Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="images\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
</p>

В данном проекте автотесты написаны на **Java** с использованием фреймворка для тестирования **Selenide**. Для сборки проекта в среде **IntelliJ IDEA** используется **Gradle**.
**JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**.

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.


## :heavy_check_mark: Тест кейсы
- Добавление товара в корзину;
- Аутентификация пользователя;
- Наличие заголовков главной страницы;
- Наличие наличия разделов на главной странице;
- Наличие рекламного слогана;
- Наличие блока c социальными сетями в подвале страницы;
- Выполнение поиска заданного товара;

## :computer: Запуск тестов из терминала
```
gradle clean test 
```

## <img width="4%" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/015_aziyatdinov_final_web/)
Для запуска тестов из Jenkins:
1. Необходимо нажать кнопку "Собрать с параметрами" и выбрать параметры.
   <img src="images/screen/Screenshot_1.png" alt="Jenkins"/>
2. Нажать кнопку "Собрать".

### :heavy_plus_sign: Параметры сборки

> - browse (браузер)
> - browserVersion (версия браузера)
> - browserSize (размер окна браузера)
> - remoteDriverUrl (url адрес Selenoid)
> - videoStorage (url адрес с видео прохождения тестов)

## :bar_chart: Отчеты о прохождении тестов доступны в Allure
### <img width="4%" title="Allure_Report" src="images/logo/Allure_Report.svg"> Allure

#### Главная страница

<img src="images/screen/Screenshot_2.png" alt="Allure"/>

#### Графики

<img src="images/screen/Screenshot_3.png" alt="Allure"/>

#### Тесты

<img src="images/screen/Screenshot_4.png" alt="Allure"/>

### <img width="3%" title="Telegram" src="images/logo/Telegram.svg"> Telegram

Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот

<img src="images/screen/Screenshot_5.png" alt="Telegram"/>

## :movie_camera: Видео с прогоном тестов

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<p align="center">
  <img title="Video" src="images/video/Lamoda_tests.gif">
</p>

## Полная статистика по прохождению тестпланов, отчёты и приложения к ним хранятся в Allure TestOps
<img width="3%" title="Allure" src="img/logo/Allure_TO.svg"> 

#### Представлены тест-кейсы

<img src="img/screen/TOTest.jpg" alt="TO"/>

#### Представлены дашборды аналитики

<img src="img/screen/TODash.jpg" alt="TO"/>

#### Представлены запуски

<img src="img/screen/TOLaunch.jpg" alt="TO"/>