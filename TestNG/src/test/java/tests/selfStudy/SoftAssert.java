package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.awt.*;
import java.time.Duration;

public class SoftAssert {

    // SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @BeforeTest
    public void login(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");
    }
    @BeforeClass
    public void launchBrowser(){
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

    }

    @BeforeMethod
    public void enterUrl(){
        //  3. Login kutusuna “username” yazin
        WebElement login =driver.findElement(By.xpath("//input[@type='text']"));
        login.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement password =driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

    }

    @Test
    public void payBillsTest(){

        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=pay-bills.html']")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select =new Select(currency) ;
        select.selectByValue("EUR");

        SoftAssert softAssert =new SoftAssert();
        String actualSelected = select.getFirstSelectedOption().getText();
        String expectedSElected = "Eurozone (Euro)";


    }

    @AfterMethod
    public void logOut(){

        driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]")).click();
        driver.findElement(By.xpath("//a[@id='logout_link']")).click();
    }
    /*  @AfterTest
      public void deleteAllCookies(){
      }*/
    @AfterClass
    public void closeBrowser(){

        driver.quit();
    }
    @AfterSuite
    public void generateTestReport(){

    }

}
