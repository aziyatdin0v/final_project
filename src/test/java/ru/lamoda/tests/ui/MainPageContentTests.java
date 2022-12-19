package ru.lamoda.tests.ui;

import com.codeborne.selenide.Driver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.lamoda.drivers.DriverSettings;
import ru.lamoda.pages.MainPage;
import ru.lamoda.tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@Owner("aziyatdinov")

public class MainPageContentTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Tag("ui")
    @Test
    @Feature("UI тесты lamoda.ru")
    @Story("Главная страница lamoda.ru")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка заголовков стартовой страницы")
    public void testTitle() {
        step("Открываем главную страницу и проверяем заголовок во вкладке браузера", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
            assertThat(title(), containsString(mainPage.TITLE));
        });
        step("Проверяем наличие заголовка страницы", () -> {
            mainPage.checkHeader();
        });
    }

    @Tag("ui")
    @Feature("UI тесты lamoda.ru")
    @Story("Главная страница lamoda.ru")
    @Severity(SeverityLevel.NORMAL)
    @CsvSource(value = {
            "Женщинам, women",
            "Мужчинам, men",
            "Детям, children"
    })
    @ParameterizedTest(name = "\"{0}\"")
    @DisplayName("Проверка наличия разделов на стартовой странице")
    void testGenderMenu(String gender, String expectedText) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Переходим в раздел " + gender + "", () -> {
            mainPage.chooseChapter(expectedText);
        });
        step("Проверяем раздел в главном меню", () -> {
            mainPage.checkChapter(gender);
        });
        step("Очищаем cookies и возращаемся на главную страницу", () -> {
            clearBrowserCookies();
            back();
        });
    }

    @Tag("ui")
    @Test
    @Feature("UI тесты lamoda.ru")
    @Story("Главная страница lamoda.ru")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка рекламного слогана")
    void testAdvertising() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Проверяем текст рекламного слогана", () -> {
            mainPage.checkAdvertisingTitle();
        });
    }

    @Tag("ui")
    @Test
    @Feature("UI тесты lamoda.ru")
    @Story("Главная страница lamoda.ru")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия блока c социальными сетями в подвале страницы")
    void testSocialNetwork() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Проверяем, что на главной странице есть блок с социальными сетями", () -> {
            mainPage.checkSocialNetworkButton();
        });
    }
}
