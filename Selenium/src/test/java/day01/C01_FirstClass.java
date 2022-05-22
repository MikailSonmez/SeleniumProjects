package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FirstClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mikai/SELENIUM/Selenium/src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // biz driver objesi olusturdugumuzda bos bir chrome browser acilir
        driver.get("https://www.amazon.com");
        // driver.get method'u driver'a gidecegi web adresini girmemizi

        // Thread.sleep(3000);

        driver.close();
        // driver'i kapatir
    }
}
