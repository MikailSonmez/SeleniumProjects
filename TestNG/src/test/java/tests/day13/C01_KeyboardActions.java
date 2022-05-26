package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions2
    @Test
    public void test() {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_UP).
                perform();

        //4- videoyu izlemek icin Play tusuna basin
        //video iframe icinde oldugundan once iframe e gecis yapmaliyiz
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton = driver.findElement(By.xpath("//button[@title='Pause (k)']"));
        Assert.assertTrue(pauseButton.isEnabled());
    }
}
