package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.lang.annotation.Target;
import java.util.Set;

//1Yeni bir class olusturalim: MouseActions1
public class MouseActions1 extends TestBase {

    @Test
    public void mouseActionsTest(){
        //https://the internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement dashedBox = driver.findElement(By.xpath("//div[@id='hot-spot']"));


        //Cizili alan uzerinde sag click yapalim
        // sag click yapuldiginda javascript kodu cikiyor karsimiza onu handle etmeliyiz
        actions.contextClick(dashedBox).build().perform();


        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim
        String alertMessage= driver.switchTo().alert().getText();
        String expectedMessage = "You selected a context menu";
        softAssert.assertEquals(alertMessage,expectedMessage);


        //Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //Buraya kadar oldugumuz sayfanin windowhandle degerini alalim
        String windowhandle1= driver.getWindowHandle();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        //Yeni bir tab acilacagi icin o sayfaya windowhandle ile gecis yapabiliriz bunun icinde yeni sayfanin windowhandle ni
        //ogrenmemiz gerekir bu ise bir kac yolla yapilabilir.Birtanesi hepsini set e atip olmayani cekmek
        Set<String> handleList = driver.getWindowHandles();
        String windowhandle2 = " ";
        for (String each: handleList) {
            if (!each.contains(windowhandle1)){
                windowhandle2=each;
            }
        }
        driver.switchTo().window(windowhandle2);
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        String h1Tag = driver.findElement(By.tagName("h1")).getText();
        String expected = "Elemental Selenium";
        softAssert.assertEquals(h1Tag,expected);
        softAssert.assertAll();

    }


}
