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

public class C01_Alerts {

    /*
    * accept()==> Bir uyarida (alert) OK i tiklamakla ayni.
    driver.switchTo().alert().accept();
    * dismiss()==> bir uyarida (alert) Cancel i iklamakla ayni
    driver.switchTo().alert().dismiss();
    * getText()==> Uyaridaki (slert) mesaji almak icin32
    */
    WebDriver driver;
    WebElement sonucYazisiElementi;

    @BeforeClass()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    //● Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert() {
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        // “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }

    @Test
    public void dismissAlert(){
        //● Bir metod olusturun:
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        //        “successfuly” icermedigini test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisiElementi= sonucYazisiElementi.getText();
        String istemenyenKelime="successfuly";

        Assert.assertFalse(actualSonucYazisiElementi.contains(istemenyenKelime));


    }

    @Test
    public void sendKeysAlert() throws InterruptedException {

        //● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Yildiz");
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisiElementi= sonucYazisiElementi.getText();
        String yazdigimizKelime="Yildiz";

        Assert.assertTrue(actualSonucYazisiElementi.contains(yazdigimizKelime));

    }

    @AfterClass
    public void teardown() {
        driver.quit();

    }

}

