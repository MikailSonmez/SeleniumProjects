package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_ImplicitlyWait {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // imlicitlyWait testimiz boyunca sayfa acilmasi ve element bulunmasi konusunda driver'in
        // bekleyecegi maximum sureyi belirler.
        // bu sure icerisinde gorevini bitirir bitirmez, bir sonraki adima gecer
        // bu sure icerisinde gorevini bitirmezse o zaman hata verir

        // belirlenen maximum sure Thread.sleep'deki gibi mutlak bekleme suresi degildir


        driver.get("https://techproeducation.com");
        Thread.sleep(5000);

        driver.close();
    }
}
