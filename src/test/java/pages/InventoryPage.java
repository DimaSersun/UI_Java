package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class InventoryPage{

    private final SelenideElement addToCart = $(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
    private final SelenideElement cartIcon = $(By.className("shopping_cart_link"));
    private final String itemName = "//div[text()='%s']";



    public InventoryPage waitPageIsLoaded(){
        addToCart.should(Condition.clickable);
        return this;
    }

    public InventoryPage addBagToCart(){
        addToCart.click();
        return this;
    }

    public CartPage navigateToCart(){
        cartIcon.click();
        return new CartPage();
    }

    public ProductPage proceedToProduct(String name){
        final SelenideElement item = $(By.xpath(String.format(itemName,name)));
        item
                .should(Condition.visible)
                .should(Condition.clickable)
                .should(Condition.matchText(name))
                .click();
        return new ProductPage();

    }
}
