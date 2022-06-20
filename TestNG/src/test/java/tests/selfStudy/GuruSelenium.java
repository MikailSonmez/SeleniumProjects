package tests.selfStudy;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class GuruSelenium {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[4]")).click();
    }

    @Test
    public void FalseFalse() {

        WebElement login = driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("Userid");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        ;
        String errorMassege = driver.switchTo().alert().getText();

        String expectedErrorMassega = "User or Password is not valid";
        softAssert.assertEquals(errorMassege, expectedErrorMassega);

    }
    @Test
    public void TrueFalse(){

    }
    @Test
    public void FalseTrue(){

    }
    @Test
    public void TrueTrue(){

    }

    @Test
    public void uyariYazisi() {
        Actions actions =new Actions(driver);

        driver.findElement(By.xpath("//input[@name='uid']")).click();


        driver.findElement(By.xpath("//input[@name='password']")).click();

        String loginUyariYazisi=driver.findElement(By.xpath("//label[@id='message23']")).getText();
        String expectedLoginYazisi="User-ID must not be blank";
        softAssert.assertEquals(loginUyariYazisi,expectedLoginYazisi);

        driver.findElement(By.xpath("//input[@name='uid']")).click();

        String passwordUyariYazisi=driver.findElement(By.xpath("//label[@id='message18']")).getText();
        String expectedPassword="Password must not be blank";
        softAssert.assertEquals(passwordUyariYazisi,expectedPassword);

        softAssert.assertAll();
    }

  /*  login
    password
            tt    login
            tf    not login
            ft    not login
            ff    not login
            _t    not login
            _f    not login
            t_    not login
            f_    not login
            __    not login
*/
    /*
    1-Amazon.com sayfasina git
    2-sign in butonunu tikla
    3-false id true password
    ile girisi test ediniz uyari yazisinin ciktigini
    Onur bey
     */





}
