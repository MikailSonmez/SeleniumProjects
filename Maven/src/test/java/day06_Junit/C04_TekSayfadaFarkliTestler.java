package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

   static WebDriver driver;
    static WebElement aramaKutusu;
    static WebElement sonucYazisiElementi;
    @Test
    public void test01(){
        // amazon sayfasinda nutella icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi= sonucYazisiElementi.getText();
        String arananKelime="nutella";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("nutella test passed");
        }else {
            System.out.println("nutella test failed");
        }
    }

    @Test
    public void test02(){
        // amazon sayfasinda java icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("java" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi= sonucYazisiElementi.getText();
        String arananKelime="java";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("Java test passed");
        }else {
            System.out.println("Java test failed");
        }
    }

    @Test
    public void test03(){
        // amazon sayfasinda ali icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        // amazon sayfasinda java icin arama yapip sonuc yazisinin nutella icerdigini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("ali" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi= sonucYazisiElementi.getText();
        String arananKelime="ali";

        if (actualSonucYazisi.contains(arananKelime)){
            System.out.println("Ali test passed");
        }else {
            System.out.println("Ali test failed");
        }
    }

   @BeforeClass
    public static void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

    }
    @AfterClass
    public  static void ortaligiTopla(){
    driver.close();
    }
}
