package tests.smokeTest;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLogInTest {

    HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void beforeMethodLoginHotel() {
        hotelmycampPage.hotelMyCampLogin();
    }

    //1) com.techproed altinda bir package olustur : smoketest
    //2) Bir Class olustur : PositiveTest
    //3) Bir test method olustur positiveLoginTest()
    //         https://www.hotelmycamp.com adresine git
    //        login butonuna bas
    //test data username: manager ,
    //test data password : Manager1!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    @Test
    public void positiveLoginTest() {
        //         https://www.hotelmycamp.com adresine git
        //        login butonuna bas
        //test data username: manager ,
        //test data password : Manager1!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Actions actions1 = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelmycampPage.mainPageLogin.click();
        hotelmycampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
        hotelmycampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
        hotelmycampPage.wait(2);


    }
}
