package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    //1 ) Bir Class olustur : PositiveTest


    //    test data username: manager ,
    //    test data password : Manager1!
    //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test (groups = {"miniRegression", "smoke"})
    public void pozitiveLoginTest() {
        //1 ) Bir Class olustur : PositiveTest
        // https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna bas
        HotelMyCampPage hotelMyCampPage= new HotelMyCampPage();
        hotelMyCampPage.mainPageLogin.click();

        // test data username: manager ,
        hotelMyCampPage.userNameBox.click();
        hotelMyCampPage.userNameBox.sendKeys("Manager1!");

        // test data password : Manager1!
        hotelMyCampPage.passwordBox.click();
        hotelMyCampPage.passwordBox.sendKeys("Manager1!");

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelMyCampPage.userLogInButonu.click();
        String actualLoginError = hotelMyCampPage.userLogInButonu.getText();
        String expectedLoginError ="Try again please";
        Assert.assertEquals(actualLoginError,expectedLoginError,"Negatif login testi FAILED, expected word is not displayed");




    }
}
