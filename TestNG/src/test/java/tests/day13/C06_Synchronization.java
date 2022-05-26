package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Synchronization extends TestBase {
    @Test
    public void test01() throws InterruptedException {
      // driver.get("https://the-internet.herokuapp.com/upload");
      // Thread.sleep(500);
      // driver.findElement(By.id("file-submit")).click();

        // Synchronization site acilim uyum hizi
        // youtube felan yavas acilir cok video secenegi var diye


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        Thread.sleep(3000);

        WebElement itsDisabledYaziElementi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsDisabledYaziElementi.isDisplayed());
        Thread.sleep(5000);

        // hard wait tidr .implicitlyWait(Duration.ofSeconds() daha iyidir cunku
        // her biri icin tek tek Thread.sleep() yapmamiza gerek kalmaz
        // eger cok sure bekliceksek .implicitlyWait tercih ederiz
        // fluentwait tekrar tekrar dene
        // implicit wait driver.manage().timeouts()
        // explicit wait WebDriverWait genellikle belli ogeler odakli kullaniriz
        // explicit'te obje uretip ozel bekletiriz
    }
}
