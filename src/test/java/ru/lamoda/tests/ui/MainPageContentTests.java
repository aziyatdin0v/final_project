package ru.lamoda.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.lamoda.pages.MainPage;
import ru.lamoda.tests.BaseTest;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MainPageContentTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Tag("ui")
    @Test
    @DisplayName("Проверка заголовка во вкладке браузера")
    public void testTitle() {
        step("Открываем главную страницу и проверяем заголовок во вкладке браузера", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
            assertThat(title(), containsString(mainPage.TITLE));
        });
    }

    @Tag("ui")
    @CsvSource(value = {
            "Женщинам, women",
            "Мужчинам, men",
            "Детям, children"
    })
    @ParameterizedTest(name = "Проверка заголовка баннера и наличия раздела \"{0}\"")
    @DisplayName("Проверка заголовка баннера и наличия разделов на нем")
    void testGenderMenu(String gender, String expectedText) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Проверяем наличие заголовка", () -> {
            mainPage.checkHeader();
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

