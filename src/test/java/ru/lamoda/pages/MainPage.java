package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    public static final String TITLE = "Интернет магазин одежды и обуви. Купить обувь, купить одежду, аксессуары в онлайн магазине Lamoda.ru";
    private static final String ADVERTISING_TITLE = "Все идеи в одном месте!";
    private static final String SUB_ADVERTISING_TITLE = "Читайте лучшие инсайты наших редакторов";
    private static final String HEADER = "Выберите интересующий вас раздел";

    private SelenideElement
            notificationCookie = $("._text_zj82w_18"),
            cookieCloseButton = $x("//button[text()=\"Хорошо\"]"),
            menuButtonIdea = $("._root_a9l6y_8"),
            advertisingTitle = $("._container_wwzzd_15 ._title_1n789_18"),
            advertisingSubTitle = $("._container_wwzzd_15 ._subTitle_1n789_23"),
            vkButton = $(".social-items a[aria-label=\"vk\"]"),
            youtubeButton = $(".social-items a[aria-label=\"youtube\"]"),
            telegramButton = $(".social-items a[aria-label=\"telegram\"]"),
            headerGender = $(".tizer-gender-select");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage cookieButtonClick() {
        if (notificationCookie.is(Condition.visible)) {
            cookieCloseButton.click();
        }
        return this;
    }

    public MainPage checkPageUrl(String url) {
        String urlPage = WebDriverRunner.url();
        assertEquals(urlPage, url);
        return this;
    }

    public MainPage checkAdvertisingTitle() {
        menuButtonIdea.hover();
        advertisingTitle.shouldHave(text(ADVERTISING_TITLE));
        advertisingSubTitle.shouldHave(text(SUB_ADVERTISING_TITLE));
        return this;
    }

    public MainPage checkSocialNetworkButton() {
        vkButton.should(appear);
        youtubeButton.should(appear);
        telegramButton.should(appear);
        return this;
    }

    public MainPage checkHeader() {
        headerGender.shouldHave(text(HEADER));
        return this;
    }

    public MainPage chooseChapter(String expectedText) {
        $(".js-ibanner-bg-image[data-gender=\"" + expectedText + "\"]").click();
        return this;
    }

    public MainPage checkChapter(String gender) {
        $("._root_1o7df_2 a[data-active=\"true\"]").shouldHave(text(gender));
        return this;
    }
}
