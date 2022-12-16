package ru.lamoda.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @BeforeAll
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://www.lamoda.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

}
