package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement yourCartButton = $(By.xpath("//span[@class='title']"));

    private final SelenideElement itemNameInCart = $(By.xpath("//div[@class='inventory_item_name']"));

    private final SelenideElement cartProductPrice = $(By.xpath("//div[@class='inventory_item_price']"));

    private final SelenideElement checkoutCartButton = $(By.xpath("//button[@id='checkout']"));

    public CartPage cartPageIsLoaded() {
        Allure.step("Wait till page is loaded");
        yourCartButton
                .should(Condition.visible, Duration.ofSeconds(3));

        return this;
    }

    public CartPage checkProductNameInCart(String expectedName) {
        Allure.step("Check if the name of product is correct");
        itemNameInCart
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedName));

        return this;
    }

    public CartPage checkProductPriceInCart(String expectedPrice) {
        Allure.step("Check if the price is correct");
        cartProductPrice
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedPrice));

        return this;
    }

    public YourInformationPage clickToCheckout() {
        Allure.step("Click to checkout button");
        checkoutCartButton
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();
        return new YourInformationPage();
    }

}
