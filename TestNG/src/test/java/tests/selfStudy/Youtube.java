package tests.selfStudy;

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

public class Youtube {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleTest(){
        // titleTest => Sayfa basliginin "YouTube" oldugunu test edin
        String titleYoutube = driver.getTitle();
        String expectedTitle = "YouTube" ;
        Assert.assertEquals(expectedTitle,titleYoutube);

    }
    @Test
    public void imageTest(){
        // imageTest => Youtube resminin goruntulrnfigini test edin
        WebElement img = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")) ;
        Assert.assertTrue(img.isDisplayed());

    }
    @Test
    public void searchBoxTest(){
        // searchBoxTest =>SearchBox'in erisilebilir oldugunu test edin
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        // wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
        String titleYoutube = driver.getTitle();
        String expectedTitle = "Youtube" ;
        Assert.assertNotEquals(expectedTitle,titleYoutube);

    }
    @AfterClass
    public  void teardown(){
        driver.close();
    }
}
