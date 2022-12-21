# Дипломный проект по тестированию интернет-магазина [Lamoda](https://www.lamoda.ru/)

## :open_book: Содержание:

* [Технологии, используемые в данном проекте](#gear-Технологии-используемые-в-данном-проекте)
* [Тест кейсы](#test_cases-Тест-кейсы)
* [Запуск тестов из терминала]()
* [Запуск тестов в Jenkins]()
* [Отчеты]()
* * [Allure]
* * [Telegram]
* [Видео прохождения тестов]()
* [Интеграция с AllureTestOps]()

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
<a href="https://web.telegram.org/"><img width="50" height="50"  alt="Telegram" src="images\logo\Telegram.svg" title="Telegram"></a>
</p>

## :test_cases: Тест кейсы
* Добавление товара в корзину;
* Аутентификация пользователя;
* Проверка заголовков главной страницы;
* Проверка наличия разделов на главной странице;
* Проверка рекламного слогана;
* Проверка наличия блока c социальными сетями в подвале страницы;
* Поиск товара;

## Запуск из терминала
```
gradle clean test 
```

## <img width="4%" title="Jenkins" src="img/logo/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/015_aziyatdinov_final_web/)
