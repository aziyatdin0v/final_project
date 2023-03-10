package ru.lamoda.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.lamoda.config.Project;
import ru.lamoda.pages.AuthUserPage;
import ru.lamoda.pages.MainPage;

import static io.qameta.allure.Allure.step;

@Owner("aziyatdinov")
@Feature("UI тесты lamoda.ru")
@Story("Авторизация пользователя")
@Tags({@Tag("ui")})

public class AuthUserTests extends BaseTest {

    MainPage mainPage = new MainPage();
    AuthUserPage authUserPage = new AuthUserPage();

    @Test
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
            authUserPage.setEmail(Project.config.userEmail());
        });
        step("Вводим пароль", () -> {
            authUserPage.setPassword(Project.config.userPassword());
        });
        step("Нажимаем Войти", () -> {
            authUserPage.enterSubmit();
        });
        step("Проверяем успешную авторизацию", () -> {
            authUserPage.modalWindowClose();
            authUserPage.checkAuth(Project.config.userEmail());
        });
        step("Выходим из личного кабинета", () -> {
            authUserPage.logOut();
        });
    }
}
