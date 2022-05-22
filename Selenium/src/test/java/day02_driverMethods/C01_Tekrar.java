package day02_driverMethods;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Tekrar {
    // Normalde selenium'un kendi IDE'si de var fakat biz daha kullanisli oldugu icin intelliJ kullaniyoruz
    // intellij'de yeni bir proje actigimizda oncelikle selenium kutuphanelerini projeye eklememiz gerekir
    // biz en ilkel haliyle projemize kutuphaneleri jar dosyalari olarak yukledik
    // bu ekledigimiz dosyalarla artik driver'in ayarlarini yapabiliriz

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:/Users/mikai/SELENIUM/Selenium/src/driver/chromedriver.exe");
        // setProperty method'u 2 parametre ister
        // iolki kullanacagimiz browser'a ait driver
        // ikinci parametre ise selenium sitesinden indirip projemize ekledigimiz chromedriver'in path'i
        // windows kullanicilari sona .exe eklerken, apple kullananlark eklememeli

        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        Thread.sleep(5000);
        // java'dan gelir, icine yazilan milisaniye kadar kodlarin calismasini durdurur

        driver.close();
        // driver.close class'in sonuna yazilir. Cunku bu kod calisinca driver'imiz kapanir
        // bu koddan sonra yeniden bir browser acmak istiyorsak driver'a yeni deger atamaliyiz

       // driver = new ChromeDriver();
        // tekrar acmak icin yeni deger
    }
}
