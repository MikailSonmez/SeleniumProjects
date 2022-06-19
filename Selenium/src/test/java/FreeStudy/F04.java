package FreeStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver() ;


        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().fullscreen();



    }
}
