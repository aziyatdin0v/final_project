package ru.lamoda.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.lamoda.config.WebDriverConfig;
import ru.lamoda.helpers.Attach;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static io.qameta.allure.Allure.step;

public class BaseTest {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class,System.getProperties());

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://www.lamoda.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        step("Очищаем cookies", () -> {
            clearBrowserCookies();
        });
    }
}
