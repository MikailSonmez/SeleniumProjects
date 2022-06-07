package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    //Yeni bir class olusturalim: D15_MouseActions4
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.click(firstNameElement).
                keyDown(Keys.SHIFT).
                sendKeys("e").
                keyUp(Keys.SHIFT).
                sendKeys("mrah").
                sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).
                sendKeys("saglam").
                keyUp(Keys.SHIFT).
                sendKeys(Keys.TAB).
                sendKeys("xyz@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Test1234!").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("25").
                sendKeys(Keys.TAB).
                sendKeys("Ocak").
                sendKeys(Keys.TAB).
                sendKeys("2022").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT) .
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(5000);
        //4- Kaydol tusuna basalim
        //WebElement kaydolElement= driver.findElement(By.xpath("//button[@id='u_16_s_6h']"));
        //driver.findElement(By.xpath("(//button[@type='submit'])[2]']")).click();
        //actions.click(kaydolElement).perform();
    }
}