package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_GetMethods {
    //1. Yeni bir package olusturalim : day01
    //2. Yeni bir class olusturalim : C01_GetMethods
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //4. sayfa basligini(tiotle) yazdirin
        System.out.println(driver.getTitle());
        //5. sayfa baslginin "Amazon" icerdigini test edin
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

        if (actualTitle.contains(arananKelime)){
            System.out.println("Title pass the test");
        } else {
            System.out.println("Title do not pass the test");
            System.out.println("Sayfanin title'i : " + actualTitle);
        }

        //6. sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        //7. sayfa url'nin "amazon" icerdigini test edin.
        String actualUrl=driver.getCurrentUrl();
        String urlArananKelime="amazon";

        if (actualUrl.contains(urlArananKelime)){
            System.out.println("url testi pass");
        } else {
            System.out.println("url testi failed");
            System.out.println("actual url : " + actualUrl);
        }

        //8. sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        //9. sayfa html kodlarinda "alisveris kelimesi gectigini test edin
        String actualPageSource=driver.getPageSource();
        String pageArananKelime="alisveris";

        if (actualPageSource.contains(pageArananKelime)){
            System.out.println("page source test is passed");
        } else {
            System.out.println("page source test is failed");
        }

        // 10. sayfayi kapatin.
        driver.close();

    }
}
