package ru.lamoda.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lamoda.pages.AddToCartPage;
import ru.lamoda.tests.BaseTest;


public class AddProductToCartTests extends BaseTest {
    AddToCartPage addToCartPage = new AddToCartPage();

    @Tag("ui")
    @Test
    @DisplayName("Проверка добавления товара в корзину")
    void testAddToCart() {
        addToCartPage.openPage()
                .choseSizeProduct()
                .addProductToCart()
                .checkPopup();
    }
}
