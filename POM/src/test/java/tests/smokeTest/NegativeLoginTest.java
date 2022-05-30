package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    // GIRIS YAPILAMADI TESTI
    HotelMyCampPage hotelMyCampPage;

    @Test
    public void yanlisSifreTest() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMYCWrongPassword"));
        hotelMyCampPage.userLogInButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYazisiElementi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMYCWrongUserName"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
        hotelMyCampPage.userLogInButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYazisiElementi.isDisplayed());
        Driver.closeDriver();


    }

    @Test
    public void yanlisSifreUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMYCWrongUserName"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMYCWrongPassword"));
        hotelMyCampPage.userLogInButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYazisiElementi.isDisplayed());
        Driver.closeDriver();


    }
}
