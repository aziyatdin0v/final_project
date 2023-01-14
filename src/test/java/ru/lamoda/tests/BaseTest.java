package ru.lamoda.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.lamoda.drivers.DriverSettings;
import ru.lamoda.helpers.Attach;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class BaseTest {

    @BeforeAll
    static void configure() {
        DriverSettings.configure();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
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
