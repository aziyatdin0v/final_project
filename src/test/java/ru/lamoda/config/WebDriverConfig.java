package ru.lamoda.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})

public interface WebDriverConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("https://www.lamoda.ru")
    String baseUrl();
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("browserVersion")
    @DefaultValue("108.0")
    String browserVersion();

    String userEmail();
    String userPassword();
    String remoteUrl();

}