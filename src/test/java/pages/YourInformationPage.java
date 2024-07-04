package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.managers.FakeDataGenerator;
import utils.constants.LoginUsers;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class YourInformationPage {

    private final SelenideElement yourInformationButton = $(By.xpath("//span[@class='title']"));
    private final SelenideElement firstNameLocator = $(By.xpath("//input[@id='first-name']"));
    private final SelenideElement secondNameLocator = $(By.xpath("//input[@id='last-name']"));
    private final SelenideElement zipCodeLocator = $(By.xpath("//input[@id='postal-code']"));
    private final SelenideElement continueButton = $(By.xpath("//input[@id='continue']"));


    public YourInformationPage informationPageIsLoaded(){
        yourInformationButton
                .should(Condition.visible, Duration.ofSeconds(3));

        return this;
    }

    public YourInformationPage firstNameData(String firstname){

        firstNameLocator.should(Condition.visible, Duration.ofSeconds(2));
        firstNameLocator.clear();
        firstNameLocator.sendKeys(firstname);
        return this;
    }

    public YourInformationPage lastNameData(String lastname){

        secondNameLocator.should(Condition.visible, Duration.ofSeconds(2));
        secondNameLocator.clear();
        secondNameLocator.sendKeys(lastname);
        return this;
    }

    public YourInformationPage zipCodeData(String zipcode){

        zipCodeLocator.should(Condition.visible, Duration.ofSeconds(2));
        zipCodeLocator.clear();
        zipCodeLocator.sendKeys(zipcode);
        Selenide.sleep(5000);
        return this;
    }

    public OverviewPage clickContinue(){
        continueButton
                .should(Condition.visible)
                .should(Condition.clickable)
                .click();
        return  new OverviewPage();
    }
}
