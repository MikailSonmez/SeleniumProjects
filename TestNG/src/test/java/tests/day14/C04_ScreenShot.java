package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_ScreenShot extends TestBase {

    @Test
    public void screentest(){
        driver.get("https://google.com");
        driver.manage().deleteAllCookies();
        TakesScreenshot tss = (TakesScreenshot) driver;
        //  TakesScreenshot objesini olusturduk deger olarak driver attik kabul etmesi icinde casting yaptik
        //Tum sayfanin screenshot ini almak icin bir File olusturalim ve
        // dosya yolunu belirtelim
        // dosyanin yeri src nin altinda
        //resim dosyasi olarak png kabul ediyor
        File tumsayfaSS = tss.getScreenshotAs(OutputType.FILE);
        tumsayfaSS =tss.getScreenshotAs(OutputType.FILE);
        File screenname = new File("src\\tumSayfa.png");
        // eger spesifik bir webelemente screenshot'ini almak istiyorsaniz

        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));
        File logoResmi=new File("src/logo.png");
        logoResmi=logoElementi.getScreenshotAs(OutputType.FILE);
    }


}
