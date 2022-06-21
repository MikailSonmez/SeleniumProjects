package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import javax.swing.*;
import java.time.Duration;

public class Pazar {

    /*
    facebook hesap olusturma sayfasi testi
    https://www.facebook.com/ sayfasindan >>>Yeni hesap olustur sayfasina gidin
     1-
     isim girisi yapin
     soy isim girisi yapin
     cep numarasi +38669645099 girin
     en az 6 rakam bir harf ve noktalama isareti olan sifre girisi yapin
     dogum tarihini 01.01.2000 girin
     cinsiyet secimi yapin farketmez
     kaydol a tiklayin
     beklenen sonuc kayit basarili olmali
     Kubra Hanim
2-
    facebook hesap olusturma sayfasi testi
    https://www.facebook.com/ sayfasindan >>>Yeni hesap olustur sayfasina gidin
     isim girisi yapin
     soy isim girisi yapin
     cep numarasi +38669645099 girin
     en az 6 rakam bir harf ve noktalama isareti olan sifre girisi yapin
     Dogum tarihi 18 yasindan kucuk bir tarih secin
     cinsiyet secimi yapin farketmez
     kaydol a tiklayin
     beklenen sonuc 18 yas alti uyarisi vermesi
     Onur Bey
facebook hesap olusturma sayfasi testi
    https://www.facebook.com/ sayfasindan >>>Yeni hesap olustur sayfasina gidin
3-isim kutusuna tiklayin birsey yazmayin
soy isim kutusuna tiklayin birsey yazmayin
butun kutulara tikladiktan sonra
kutularin ne olduguna dayir uyari cikiyor
uyari yazilarinin gorundugunun test edin
Salih Bey
4-facebook hesap olusturma sayfasi testi
    https://www.facebook.com/ sayfasindan >>>Yeni hesap olustur sayfasina gidin
     isim girisi yapin
     soy isim girisi yapin
     cep numarasi aaaaaaaaaa girin
     en az 6 rakam bir harf ve noktalama isareti olan sifre girisi yapin
     dogum tarihini 01.01.2000 girin
     cinsiyet secimi yapin farketmez
     kaydol a tiklayin
     telefon icin uyari yazisi almalisiniz yazinin gorundugunu test edin
     Cem abi
      */

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.amazon.com");
    }

    @Test(priority = 1)
    public void warning_letter() throws InterruptedException{

        Actions actions = new Actions(driver);
        WebElement signInElementi = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(signInElementi).perform();
        driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]")).click();
        WebElement textBox = driver.findElement(By.xpath("//input[@id='ap_email']"));
        textBox.sendKeys("aliatabak", Keys.ENTER);
        String warningLetter = driver.findElement(By.xpath("//h4[text()='There was a problem']")).getText();
        String expected = "There was a problem";
        Assert.assertEquals(warningLetter, expected, " farkli bir uyari yazisi var");
    }

    @Test(priority = 4)
    public void TrueTrue() {

        Actions actions = new Actions(driver);
        WebElement signInElementi = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(signInElementi).perform();

        driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]")).click();

        WebElement signInUserElementi = driver.findElement(By.xpath("//input[@id='ap_email']"));
        signInUserElementi.sendKeys("gurutechproeducation@gmail.com");

        WebElement signInContinueElementi = driver.findElement(By.xpath("//input[@id='continue']"));
        signInContinueElementi.click();

        WebElement signInPasswordElementi = driver.findElement(By.xpath("//input[@id='ap_password']"));
        signInPasswordElementi.sendKeys("guru2022");

        WebElement sigInSonElementi = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
        sigInSonElementi.click();

        WebElement actualSignInGuruElementi = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        String actualsignInGuru = actualSignInGuruElementi.getText();
        String expectedGuru = "Hello, guru";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualsignInGuru, expectedGuru);

    }


    @Test(priority = 2)

    public void trueIdFalsePasswordTest() {
        // 1-Amazon.com sayfasina git


        // 2-sign in butonunu tikla
        //driver.findElement(By.xpath("//input[@class='a-button-input']")).click(); //cookies için

        WebElement helloSignIn = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(helloSignIn).perform(); //hellosign'de bekledi
        WebElement signInButonu = driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
        actions.click(signInButonu).perform(); //signin butonuna tıkladı

        // 3-true id false password
        WebElement emailButonu = driver.findElement(By.xpath("//input[@id='ap_email']"));
        emailButonu.sendKeys("gurutechproeducation@gmail.com", Keys.ENTER);

        WebElement passwordButonu = driver.findElement(By.xpath("//input[@id='ap_password']"));
        passwordButonu.sendKeys("guruguru", Keys.ENTER);

        // ile girisi test ediniz beklenen sonuc girisin olamamasi
        WebElement hataYazısı = driver.findElement(By.xpath("//h4[text()='There was a problem']"));

        String expectedSonuç = "There was a problem";
        String actualSonuç = hataYazısı.getText();

        Assert.assertEquals(actualSonuç, expectedSonuç);


    }

    @Test (priority = 3)
    public void setup() {


        //    2-sign in butonunu tikla
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();

        //    false id
        WebElement UserIdKutusuElementi = driver.findElement(By.xpath("//input[@id='ap_email']"));
        UserIdKutusuElementi.sendKeys("anam@be.com");
        //Actions actions= new Actions(driver);
        driver.findElement(By.xpath("//span[@class='a-button a-button-span12 a-button-primary']")).click();


        String uyariCumlesi = driver.findElement(By.xpath("//h4[text()='There was a problem']")).getText();
        String expectedCumle = "There was a problem";

        //False ID ile girisi test ediniz. Beklenen sonuc girisin olamamasi

        //Assert.assertEquals(uyariCumlesi.equals(expectedCumle));
        if (uyariCumlesi.contains(expectedCumle)) {
            System.out.println("False ID ile giriste uyari yazisi gozuktu; test PASSED");
            //}else {
            //System.out.println("Uyari yazisi gozukmedi; test FAILED");

        }

    }
}
