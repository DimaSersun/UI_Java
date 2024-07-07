package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {
    private final SelenideElement overviewButton = $(By.xpath("//span[@class='title']"));

    private final SelenideElement overviewItemName = $(By.xpath("//div[@class='inventory_item_name']"));
    private final SelenideElement overviewItemPrice = $(By.xpath("//div[@class='inventory_item_price']"));
    private final SelenideElement finishButton = $(By.xpath("//button[@id='finish']"));

    public OverviewPage overviewPageIsLoaded(){
        Allure.step("Wait till is Overview Page is Loaded");
        overviewButton
                .should(Condition.visible, Duration.ofSeconds(3));

        return this;
    }

    public OverviewPage checkProductNameInOverview(String expectedName) {
        Allure.step("Check if the name is correct");
        overviewItemName
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedName));

        return this;
    }
    public OverviewPage checkProductPriceInOverview(String expectedPrice) {
        Allure.step("Check if the price is correct");
        overviewItemPrice
                .should(Condition.visible)
                .should(Condition.appear)
                .should(Condition.exactText(expectedPrice));

        return this;
    }
    public CompletePage clickOnFinishButton(){
        Allure.step("Click in Finish Button");
        finishButton
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();

        return new CompletePage();
    }
}
