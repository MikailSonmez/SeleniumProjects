package tests.day27;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderNegatifLogintesti {


    @DataProvider
    public static Object[][] wrongUserList() {

        String liste[][]={{"manager11","manager11"},{"manager12","manager12"},{"manager13","manager13"}};
        return liste;
    }

    @Test(dataProvider = "wrongUserList")
    public void yanlisSifreUsernameTesti(String wrongUsername, String wrongPassword){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(wrongUsername);
        hotelMyCampPage.passwordBox.sendKeys(wrongPassword);
        hotelMyCampPage.userLogInButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYazisiElementi.isDisplayed());
        Driver.closeDriver();
    }
}
