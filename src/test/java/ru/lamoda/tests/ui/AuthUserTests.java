package ru.lamoda.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.AuthUserPage;
import ru.lamoda.pages.MainPage;
import ru.lamoda.tests.BaseTest;

import static io.qameta.allure.Allure.step;


public class AuthUserTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AuthUserPage authUserPage = new AuthUserPage();

    @Tag("ui")
    @Test
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
            authUserPage.setEmail("lamoda.user@yandex.ru");
        });
        step("Вводим пароль", () -> {
            authUserPage.setPassword("hobene1515");
        });
        step("Нажимаем Войти", () -> {
            authUserPage.enterSubmit();
        });
        step("Проверяем успешную авторизацию",()-> {
            authUserPage.modalWindowClose();
            authUserPage.checkAuth("lamoda.user@yandex.ru");
        });
        step("Выходим из личного кабинета",()-> {
            authUserPage.logOut();
        });
    }
}
