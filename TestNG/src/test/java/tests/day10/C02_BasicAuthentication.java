package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


    //1-Bir class olusturun : BasicAuthentication
    public class C02_BasicAuthentication {


        //4-Basarili bir sekilde saufaya girildigini dogrulayin.

        WebDriver driver;

        @BeforeClass()
        public void setUp() {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            //2-https://the-internet.herokuapp.com/basic_auth sayfasina gidin
            //    driver.get("https://the-internet.herokuapp.com/basic_auth ");


        }

        @Test
        public void authenticationTest() {
            //3-Asagidaki yontem ve test datalarini kullanarak authentication i yapin

            //   Html komutu : https://username:password@URL
            //   Username: admin
            //   Password: admin
            // basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle
            // authentication yapabilecegimiz bilgisini de vermek zorundadir
            // bizde bize tarif edilen yontem ve bize verilen bilgileri birebir uygulayarak
            // istedigimiz webserviceye giris yapabiliriz
            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
            //4-Basarili bir sekilde saufaya girildigini dogrulayin.
            WebElement congratMessageElement = driver.findElement(By.tagName("p"));
            Assert.assertTrue(congratMessageElement.isDisplayed());

        }

        @AfterClass
        public void teardown() {
            driver.close();
        }
    }

