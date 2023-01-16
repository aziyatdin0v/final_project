# Дипломный проект по тестированию интернет-магазина [Lamoda](https://www.lamoda.ru/)

## :open_book: Содержание:

- [Технологии и инструменты](#gear-Технологии-и-инструменты)
- [Тест кейсы](#heavy_check_mark-Тест-кейсы)
- [Запуск тестов](#computer-запуск-тестов-из-терминала)
- [Примеры использования](#примеры-использования)
- [Запуск тестов в Jenkins](#-запуск-тестов-из-jenkins)
- [Allure отчет](#-allure)
- [Уведомления в Telegram](#-telegram)
- [Видео прохождения тестов](#movie_camera-видео-с-прогоном-тестов)
- [Интеграция с Allure TestOps](#-Allure-TestOps)

## :gear: Технологии и инструменты

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50" alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media\logo\Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="media\logo\Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
</p>

В данном проекте автотесты написаны на **Java** с использованием фреймворка для тестирования **Selenide**. Для сборки проекта в среде **IntelliJ IDEA** используется **Gradle**.
**JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**.

**Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.

## :heavy_check_mark: Тест кейсы

- Проверка добавление товара в корзину
- Проверка аутентификации пользователя
- Проверка наличия заголовков главной страницы
- Проверка наличия разделов на главной странице
- Проверка наличия рекламного слогана
- Проверка наличия блока c социальными сетями в подвале страницы
- Проверка поиска заданного товара

## :computer: Запуск тестов

### :house_with_garden:	Локальный запуск тестов

```bash
gradle clean test
```

### :earth_asia: Удаленный запуск тестов из Jenkins

```bash
gradle clean test
-Dbrowser=${browser}
-DbrowserVersion=${browserVersion}
-DbrowserSize=${browserSize}
-DremoteDriverUrl=https://%s:%s@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
```
## Примеры использования

### Для запуска удаленных тестов необходимо заполнить remote.properties или передать значение:

* browser (браузер, по умолчанию chrome)
* browserVersion (версия браузера, по умолчанию 100.0)
* browserSize (размер окна браузера, по умолчанию 1920x1080)
* remoteDriverUrl (url адресс selenoid)
* videoStorage (url адрес с видео прохождения тестов)
* threads (количество потоков)

Запуск тестов с заполненным remote.properties:
```bash
gradle clean test
```

Запуск тестов с незаполненным remote.properties:
```bash
gradle clean test -Dbrowser=chrome -DbrowserVersion=100.0 -DbrowserSize=1920x1080 -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1
```

## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/015_aziyatdinov_final_web/)
Для запуска сборки необходимо перейти в раздел <code><strong>*Собрать с параметрами*</strong></code> и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="media/screen/start_jenkins.png" alt="Jenkins" width="800">
</p>

## :bar_chart: Отчеты о прохождении тестов доступны в Allure
### <img width="4%" title="Allure_Report" src="media/logo/Allure_Report.svg"> Allure

#### Главная страница

<img src="media/screen/Screenshot_2.png" alt="Allure"/>

#### Графики

<img src="media/screen/Screenshot_3.png" alt="Allure"/>

#### Тесты

<img src="media/screen/Screenshot_4.png" alt="Allure"/>

### <img width="3%" title="Telegram" src="media/logo/Telegram.svg"> Telegram

Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот

<img src="media/screen/Screenshot_5.png" alt="Telegram"/>

## :movie_camera: Видео с прогоном тестов

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<p align="center">
  <img title="Video" src="media/video/Lamoda_tests.gif">
</p>

## <img width="3%" title="Allure_TO" src="media/logo/Allure_TO.svg"> Allure TestOps

## Полная статистика по прохождению тестпланов, отчёты и приложения к ним

### Представлены тест-кейсы

<img src="media/screen/Allure_TestOps_Test_Cases.png" alt="TO"/>

### Представлены дашборды аналитики

<img src="media/screen/Allure_TestOps_Dashboards.png" alt="TO"/>

### Представлены запуски

<img src="media/screen/Allure_TestOps_Launches.png" alt="TO"/>