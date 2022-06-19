package freeStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class F05 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
    }

    @AfterClass
    public static void teardown(){
        //  driver.close();
    }

    @Test
    public void test01(){
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        driver.getCurrentUrl();
        WebElement userId= driver.findElement(By.xpath("//input[@id='user_login']"));
        userId.sendKeys("onur");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();



    }
    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        WebElement userId= driver.findElement(By.xpath("//input[@id='user_login']"));
        userId.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        Thread.sleep(2000);
        password.sendKeys("onur");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

    }
    @Test
    public void test03() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        WebElement userId= driver.findElement(By.xpath("//input[@id='user_login']"));
        userId.sendKeys("recep");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        Thread.sleep(2000);
        password.sendKeys("onur");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

    }

    @Test
    public void test04() throws InterruptedException {

        WebElement userId = driver.findElement(By.xpath("//input[@id='user_login']"));
        userId.sendKeys("");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        Thread.sleep(2000);
        password.sendKeys("");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

    }
    @Test
    public void test05() throws InterruptedException {


        driver.findElement(By.xpath("//a[text()='Forgot your password ?']")).click();
        WebElement emailBox= driver.findElement(By.xpath("//input[@id='user_email']"));
        Assert.assertTrue(emailBox.isDisplayed());
        System.out.println("Forgot your password link Testi PASSED");

        driver.navigate().back();
    }


    @Test
    public void test06(){

        // driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        WebElement userId= driver.findElement(By.xpath("//input[@id='user_login']"));

        userId.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    }
}