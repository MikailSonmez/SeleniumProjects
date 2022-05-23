package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    }
    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle=driver.getTitle();
        String istenenKelime="YouTube";
        Assert.assertEquals(actualTitle,istenenKelime);
    }
    @Test
    public void imageTest(){
        //○ imageTest=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageElementi=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("image gorunuyor",imageElementi.isDisplayed());

    }
    @Test
    public void searchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElementi=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBoxElementi.isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle=driver.getTitle();
        String istenmeyenKelime="youtube";

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }



}
