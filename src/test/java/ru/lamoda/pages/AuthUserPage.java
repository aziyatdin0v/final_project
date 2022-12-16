package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class AuthUserPage {

    SelenideElement
            loginButton = $x("//a[text()=\"Войти\"]"),
            emailInput = $(".input__input[name=\"login\"]"),
            passwordInput = $(".input__input[name=\"password\"]"),
            submitButton = $(".x-button[type=\"submit\"]"),
            modalWindow = $(".d-modal"),
            modalWindowButton = $(".d-modal__bottom .x-button"),
            profileButton = $x("//a[text()=\"Профиль\"]"),
            userDataButton = $("a[href='/customer/account/?sitelink=profile_hover_menu']"),

            emailCheck = $("._root_lx6hi_15 ._row_lx6hi_2", 1).lastChild(),

            logOutButton = $x("//a[text()=\"Выйти\"]");

    public AuthUserPage openAuthUserWindow() {
        loginButton.click();
        return this;
    }

    public AuthUserPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AuthUserPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public AuthUserPage enterSubmit() {
        submitButton.click();
        return this;
    }

    public AuthUserPage modalWindowClose() {
        if (modalWindow.is(Condition.visible)) {
            modalWindowButton.click();
        }
        return this;
    }

    public AuthUserPage checkAuth(String value) {
        profileButton.hover();
        userDataButton.click();
        emailCheck.shouldHave(text(value));
        return this;
    }

    public AuthUserPage logOut() {
        profileButton.hover();
        logOutButton.click();
        return this;
    }
}
