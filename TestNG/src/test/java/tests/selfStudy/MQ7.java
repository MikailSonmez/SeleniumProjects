package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MQ7 {
    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test (priority = 1)
    public void test1() {
        driver.get("https://www.n11.com/");
    }

    @Test (priority = 2)
    public void test2() {
        driver.get(" https://www.gittigidiyor.com/ ");
    }

    @Test (priority = 3)
    public void test3() {
        driver.get("https://getir.com/ ");
    }

    @Test (priority = 4)
    public void test4() {
        driver.get("https://www.sahibinden.com/");
    }


}
