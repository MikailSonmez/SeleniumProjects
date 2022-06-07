package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions2 extends TestBase {

    //Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public void test() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakHedefElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        WebElement tasinacakElemen = driver.findElement(By.xpath("(//div[@id='draggable'])[1]"));
        actions.dragAndDrop(tasinacakElemen,tasinacakHedefElement).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Thread.sleep(3000);
        String actualText=tasinacakHedefElement.getText();
        String expectedText = "Dropped!";
        Assert.assertTrue(actualText.contains(expectedText));

    }
}
