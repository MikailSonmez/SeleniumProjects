package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertion {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void test01(){
      //  1) Bir class oluşturun: BestBuyAssertions
      //  2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        driver.get("https://www.bestbuy.com/");
      //    ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";

        Assert.assertEquals("lutfen test degerlerini gozden gecirin",expectedURL,actualURL);
      //    ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle=driver.getTitle();
        String istenmeyenKelime="Rest";

        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
      //    ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("logo gorunmuyor",logoElementi.isDisplayed()); // hata mesajlarini yazarsak hatayi sonradan gorebiliriz
      //    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francais=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francais.isDisplayed());


    }
    @After
    public void teardown(){
       // driver.close();
    }
}
