package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.InventoryPage;
import utils.data.Data;
import utils.data.DataSet;
import utils.managers.FakeDataGenerator;

public class TestBuyItem extends BaseTest {

    @BeforeMethod
    public void DataGenerator(){
            DataSet.put(Data.FIRST_NAME,FakeDataGenerator.fakeFirstName());
            DataSet.put(Data.LAST_NAME,FakeDataGenerator.fakeLastName());
            DataSet.put(Data.ZIP_CODE,FakeDataGenerator.fakeZipCode());
        }

    @DataProvider(name = "ProductsData")
    public Object[][] getProductsData() {
        return new Object[][]{
                {"Sauce Labs Bike Light", "$9.99"},
//                {"Sauce Labs Backpack", "$29.99"},
//                {"Sauce Labs Bolt T-Shirt", "$15.99"},
//                {"Sauce Labs Fleece Jacket", "$49.99"}
        };
    }

    @Test(description = "BuyItemFlow", dataProvider = "ProductsData")
    public void buyTest(String productName, String expectedPrice) {
        AuthPage authPage = new AuthPage();

        authPage
                .loginAsStandardUser()
                .proceedToProduct(productName)
                .waitPageIsLoaded()
                .checkProductName(productName)
                .checkProductPrice(expectedPrice)
                .addToCart()
                .clickToCart()
                .checkProductNameInCart(productName)
                .checkProductPriceInCart(expectedPrice)
                .clickToCheckout()
                .informationPageIsLoaded()
                .firstNameData(DataSet.get(Data.FIRST_NAME))
                .lastNameData(DataSet.get(Data.LAST_NAME))
                .zipCodeData(DataSet.get(Data.ZIP_CODE))
                .clickContinue()
                .checkProductNameInOverview(productName)
                .checkProductPriceInOverview(expectedPrice)
                .clickOnFinishButton()
                .completePageIsLoaded()
                .finalInfoIsVisible()
                .clickBackHomeButton();

    }
}
