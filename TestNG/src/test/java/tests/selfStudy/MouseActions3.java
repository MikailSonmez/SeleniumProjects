package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class MouseActions3 extends TestBase {


    @Test
    public void test() throws InterruptedException {
        //https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin //mouse’u bu menunun ustune getirelim
        WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();
        //--“Create a list” butonuna basalim
        WebElement listEelement= driver.findElement(By.xpath("(//a[@class='nav-link nav-item'])[1]"));
        actions.click(listEelement).perform();
        //Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String actualTitle = driver.findElement(By.xpath("//div[@role='heading']")).getText();
        softAssert.assertEquals(actualTitle,"Your Lists");
    }
}
