package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotKlasoru extends TestBase {
    WebElement aramaKutusu;

    @Test(priority = 1)
    public void javaTest() throws IOException {

        driver.get("https://www.amazon.com");
        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        tumSayfaScreenShot();
    }
    @Test (priority = 2)
    public void nutellaTest() throws IOException {
        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        tumSayfaScreenShot();

    }
    @Test (priority = 3)
    public void elmaTest() throws IOException {
        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Elma" + Keys.ENTER);
        tumSayfaScreenShot();

    }
}
