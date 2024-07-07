package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CompletePage {
    private final SelenideElement checkCompleteText = $(By.xpath("//span[@class='title']"));
    private final SelenideElement checkFinalInfo = $(By.xpath("//h2[@class='complete-header']"));
    private final SelenideElement checkBackHomeButton = $(By.xpath("//button[@id='back-to-products']"));

    public CompletePage completePageIsLoaded(){
        Allure.step("Wait till complete page is loaded");
        checkCompleteText
                .should(Condition.visible, Duration.ofSeconds(3));

        return this;
    }
    public CompletePage finalInfoIsVisible(){
        Allure.step("Check if the congratulation text is present");
        checkFinalInfo
                .should(Condition.visible, Duration.ofSeconds(3));

        return this;
    }
    public InventoryPage clickBackHomeButton(){
        Allure.step("Click on Back Home Button");
        checkBackHomeButton
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();
        return new InventoryPage();
    }
}
