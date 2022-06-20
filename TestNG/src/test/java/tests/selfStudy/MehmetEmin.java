package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class MehmetEmin extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //1- Yeni bir class olusturalim: C03_MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();

        Thread.sleep(2000);
        //4- Alert'te cikan yazinin "You selected a context menu" oldugunu
        //    test edelim.

        String expectedAllertYazisi="You selected a context menu";
        String actualAllertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualAllertYazisi,expectedAllertYazisi,"allert yazisi beklenenden farkli");
        Thread.sleep(2000);

        //5- Tamam diyerek alert'I kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandle=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Thread.sleep(2000);

        //7- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        Set<String> windowTumHandlelar=driver.getWindowHandles();

        String ikinciSayfaHandle="";

        for (String each:windowTumHandlelar) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);

        String expectedIkinciSayfaYazi="Elemental Selenium";
        String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualIkinciSayfaYazisi,expectedIkinciSayfaYazi,"ikinci sayfadaki yai istenenden farkli");
    }

}
