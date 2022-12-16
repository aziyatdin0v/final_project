package ru.lamoda.tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.AuthUserPage;
import ru.lamoda.pages.MainPage;
import ru.lamoda.tests.BaseTest;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static io.qameta.allure.Allure.step;


public class AuthUserTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AuthUserPage authUserPage = new AuthUserPage();

    @Tag("ui")
    @Feature("UI тесты lamoda.ru")
    @Story("Авторизация пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Авторизация пользователя (вход в личный кабинет)")
    void testAuthUser() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage()
                    .cookieButtonClick();
        });
        step("Открываем окно авторизации", () -> {
            authUserPage.openAuthUserWindow();
        });
        step("Вводим email пользователя", () -> {
            authUserPage.setEmail(config.userEmail());
        });
        step("Вводим пароль", () -> {
            authUserPage.setPassword(config.userPassword());
        });
        step("Нажимаем Войти", () -> {
            authUserPage.enterSubmit();
        });
        step("Проверяем успешную авторизацию",()-> {
            authUserPage.modalWindowClose();
            authUserPage.checkAuth(config.userEmail());
        });
        step("Выходим из личного кабинета",()-> {
            authUserPage.logOut();
        });
    }
}
