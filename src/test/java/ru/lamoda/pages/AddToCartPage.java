package ru.lamoda.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddToCartPage {

    private static final String URL_PRODUCT = "/p/rtlaac315301/clothes-underarmour-bryuki-sportivnye/";

    SelenideElement
            dropdownSizes = $("._select_1pcah_10"),
            chooseDropdownSize = $(".recaptcha .ui-product-page-sizes-chooser-item_enabled", 0),
            addCartButton = $("._wrapper_lky3q_2 .x-button"),
            popupText = $(".d-modal__frame .d-modal__header");


    public AddToCartPage openPage() {
        open(URL_PRODUCT);
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
