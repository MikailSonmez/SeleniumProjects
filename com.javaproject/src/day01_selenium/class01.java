package day01_selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/mikai/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
    }
}
