package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AddToCartPage {

    //private static final String URL_PRODUCT = "/p/rtlabw776801/clothes-uniqlo-futbolka/";

    SelenideElement
            dropdownSizes = $x("//div[text()=\"Выберите размер\"]"),
            chooseDropdownSize = $(".recaptcha .ui-product-page-sizes-chooser-item_enabled", 0),
            addCartButton = $x("//button/span[text()=\"Добавить в корзину\"]"),
            popupText = $(".d-modal__frame .d-modal__header");

    public AddToCartPage openPage() {
        open("/p/rtlabw776801/clothes-uniqlo-futbolka/");
        return this;
    }

    public AddToCartPage choseSizeProduct() {
        dropdownSizes.click();
        chooseDropdownSize.click();
        return this;
    }

    public AddToCartPage addProductToCart() {
        addCartButton.click();
        return this;
    }

    public AddToCartPage checkPopup() {
        popupText.shouldHave(text("Товар добавлен в корзину"));
        return this;
    }

}
