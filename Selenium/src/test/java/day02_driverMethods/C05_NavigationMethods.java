package day02_driverMethods;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_NavigationMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        //2. youtube ana sayfasina gidelim. https://ww.wyoutube.com/
        driver.navigate().to("https://www.youtube.com/");
        //3. amazon sayfasina gidelim https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        //4. tekrar  youtube sayfasina donelim
        driver.navigate().back();
        //5. yeniden amazon sayfasina gidelim
        driver.navigate().forward();
        //6. sayfayi Reflesh() yapalim
        driver.navigate().refresh();
        //7. sayfayi kapatalim / tum sayfalari kapatalim
        driver.quit(); // quit driver'in actigi tum sayfalari kapatir
                        // close ise sadece driver'in son bulundugu sayfayi kapatir

    }
}
