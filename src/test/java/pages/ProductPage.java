package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement backButton = $(By.xpath("//button[@id='back-to-products']"));
    private final SelenideElement actualProductName = $(By.xpath("//div[@class='inventory_details_name large_size']"));
    private final SelenideElement actualProductPrice = $(By.xpath("//div[@class='inventory_details_price']"));
    private final SelenideElement addToCartButton = $(By.xpath("//button[@id='add-to-cart']"));
    private final SelenideElement clickOnCart = $(By.xpath("//div[@id='shopping_cart_container']"));

    public ProductPage waitPageIsLoaded() {
        Allure.step("Wait till the page is open");
        backButton
                .should(Condition.visible, Duration.ofSeconds(3))
                .should(Condition.clickable, Duration.ofSeconds(3));

        return this;
    }

    public ProductPage checkProductName(String expectedName) {
        Allure.step("Check the product Name");
        actualProductName
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedName));

        return this;
    }

    public ProductPage checkProductPrice(String expectedPrice) {
        Allure.step("Check the product Price");
        actualProductPrice
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedPrice));

        return this;
    }

    public ProductPage addToCart() {
        Allure.step("Click on Add to Cart Button");
        addToCartButton
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();
        return this;
    }

    public CartPage clickToCart(){
        Allure.step("Go to the Cart");
        clickOnCart
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();
        return new CartPage();
    }
}
