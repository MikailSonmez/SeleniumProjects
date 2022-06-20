package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HepsiBurada {





    //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //1. “https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");
    }
   //@BeforeClass
   //public void setUp02(){
   //    WebDriverManager.operadriver().setup();
   //    driver = new OperaDriver();
   //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   //    driver.manage().window().maximize();
   //    //1. “https://www.hepsiburada.com/” Adresine gidin
   //    driver.get("https://www.hepsiburada.com/");
   //}
    @Test
    public void test() {
//2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        String actualTitle = driver.getTitle();
        String  expectedTitle= "Turkiye’nin En Buyuk Alisveris Sites";
        Assert.assertEquals(actualTitle,expectedTitle,"Baslik yazisi dogru degil");
    }
    @Test
    public void searchBox(){
        //3. search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("araba", Keys.ENTER);
        //4. bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//div[@class='moria-search-results-count']"));
        System.out.println(result.getText());
        //5. sonuc yazisinin "araba" icerdigini dogrulayin
        String expected = "araba";
        Assert.assertTrue(result.getText().contains(expected));
        //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        String sonuc = "oto";
        Assert.assertTrue(result.getText().contains(sonuc),"sonuc icinde oto icermiyor");

    }

    @AfterClass
    public void teardown() {

    }

}
