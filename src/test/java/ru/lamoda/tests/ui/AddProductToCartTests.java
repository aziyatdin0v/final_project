package ru.lamoda.tests.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.AddToCartPage;
import ru.lamoda.tests.BaseTest;

@Owner("aziyatdinov")
@Feature("UI тесты lamoda.ru")
@Story("Добавление товара в корзину")

public class AddProductToCartTests extends BaseTest {
    AddToCartPage addToCartPage = new AddToCartPage();

    @Tag("ui")
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка добавления товара в корзину")
    void testAddToCart() {
        addToCartPage.openPage()
                .choseSizeProduct()
                .addProductToCart()
                .checkPopup();
    }
}
