package day04_XpathCssSelectore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
       // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//button[@class='added-manually']"));
       if (deleteButonu.isDisplayed()){
           System.out.println("delete butonu gorunuyor testi Pass");
       } else {
           System.out.println("delete butonunu gorunuyor testi Failed");
       }
        // 4- Delete tusuna basin
        deleteButonu.click();
       // 5- Delete butonunun gorunur olmadigini test edin
        WebElement addYazisiElementi1=driver.findElement(By.xpath("//h3"));
        WebElement addYazisiElementi2=driver.findElement(By.tagName("h3"));

        if (addYazisiElementi1.isDisplayed()){
            System.out.println("add yazisi testi passed");
        }else {
            System.out.println("add yazisi gorunuyor testi failed");
        }
        driver.close();

    }
}
