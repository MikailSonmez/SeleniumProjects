package day03_webElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementGetMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz

        driver.get("http://a.testaddressbook.com");

        // signIn linkini locate edelim

        WebElement signInLinki= driver.findElement(By.id("sign-in"));

        System.out.println("size : " + signInLinki.getSize());
        System.out.println("aria role : " + signInLinki.getAriaRole());
        System.out.println("accessible name : " + signInLinki.getAccessibleName());
        System.out.println("id attribute value'su : " + signInLinki.getAttribute("id"));
        System.out.println("location : " + signInLinki.getLocation());
        System.out.println("size : " + signInLinki.getRect().width); // getRect() . dan sonra x y width heigth etc.
        System.out.println("colour : " + signInLinki.getCssValue("color"));
        // size : (64, 40)
        // aria role : link
        //accessible name : Sign in
        //id attribute value'su : sign-in
        //location : (74, 8)
        //size : 64
        //colour : rgba(0, 0, 0, 0.5)

        driver.close();
    }
}
