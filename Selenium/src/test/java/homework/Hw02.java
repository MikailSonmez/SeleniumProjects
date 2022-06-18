package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hw02 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //2.
        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");

        if (driver.getTitle().contains("facebook")){
            System.out.println("verify");
        } else {
            System.out.println(driver.getTitle());
        }
        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("verify");
        } else {
            System.out.println(driver.getCurrentUrl());
        }
        //4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        if (driver.getTitle().contains("Walmart.com")) {
            System.out.println("verify");
        } else {
            System.out.println("false");
        }

        //6.Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //7.Sayfayi yenileyin
        driver.navigate().refresh();
        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //9.Browser’i kapatin
        driver.quit();

    }
}
