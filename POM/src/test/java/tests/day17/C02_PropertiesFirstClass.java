package tests.day17;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;


public class C02_PropertiesFirstClass {


    @Test
    public void positiveLoginTest() {

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();
        //  test data username: manager
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
        //  test data password : Manager1!
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
        hotelMyCampPage.wait(2);
        hotelMyCampPage.userLogInButonu.click();

        Assert.assertTrue(hotelMyCampPage.basariliGirisYazisiElementi.isDisplayed());

    }
}
