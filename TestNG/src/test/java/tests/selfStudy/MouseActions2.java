package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class MouseActions2 extends TestBase {


    @Test
    public void demoqaTest() {

        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //--“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim}
        WebElement sourcelocator = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement destinationlocator = driver.findElement(By.xpath("//div[@id='droppable']"));
        //  action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
        Actions action = new Actions(driver);
        WebElement drophere = driver.findElement(By.tagName("p"));
        action.dragAndDrop(sourcelocator, destinationlocator).build().perform();
        //--“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropped = driver.findElement(By.tagName("p"));

        softAssert.assertNotEquals(dropped, drophere);
        softAssert.assertAll();
    }
}
