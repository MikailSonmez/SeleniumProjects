package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuter extends TestBase {
    // amazon a gidip
    // sell linkine JsExecuter ile tiklayalim
    // ilgili sayfaya gittigimizi test edelim

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //1. adim JsExecutor objesi olusturup driver i cast edelim
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // 2. adim ilgili web elementi locate edelim
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[1]")).click();

        WebElement sellElement = driver.findElement(By.xpath("//a[text()='Sell']"));

        //3. adim ilgili script ve argument(bizim web elementimiz) ile objemiz uzerinden
        // executeScript methodunu calistiralim

        jse.executeScript("arguments[0].click",sellElement);

    }
}
