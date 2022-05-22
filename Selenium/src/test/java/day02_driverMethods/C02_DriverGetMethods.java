package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/mikai/SELENIUM/Selenium/src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        System.out.println(driver.getTitle()); // sayfanin title'ini getirir // Amazon.com

        System.out.println(driver.getCurrentUrl()); // https://www.amazon.com/

        System.out.println(driver.getWindowHandle()); // CDwindow-A722691AE9E40AF5D34E66F5B7C9C8E3 o anda acilan web sayfasi her seferinde degisir

        System.out.println(driver.getPageSource()); // sayfada sag tik incele yaptigimiz her sey gelir


    }
}
