package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthPage;

public class TestBuyItem extends BaseTest {

    @DataProvider(name="ProductsNames")
    public Object[][] getData(){
        return new Object[][]{
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Backpack"}
        };
    }
    @Test(description = "BuyItemFlow",dataProvider = "ProductsNames")
    public void buyTest(String productName) {
        AuthPage authPage = new AuthPage();

        authPage
                .loginAsStandardUser()
                .proceedToProduct(productName)
                .waitPageIsLoaded()
                .checkProductName(productName);
    }
}
