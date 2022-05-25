package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void windowHandleTest() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement pageWord = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageWord.getText(), "Opening a new window", "sayfadaki yazi dogru degil");
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(), "The Internet", "Sayfa title i dogru degil");
        //● Click Here butonuna basın.
        // soruda windowhandle degerini bilmedigim bir wiondow aciliyor
        // o sayfanin window handle degerini bulmak icin gectigim sayfalardaki
        // window handle degerini kaydetmeliyiz
        String windowhandle1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //acilan yeni pencerenin sayfa basliginin title "New Window" oldugunu dogrulayin
        //  once acilan yeni sayfanin handle degerini elde etmeliyim
        // once tum handle degerlerrini alip bir set a koyalim

        Set<String> handledegerleriSet = driver.getWindowHandles();
        String handledegeri2 = " ";
        for (String each : handledegerleriSet) {
            if (!each.equals(windowhandle1)) {
                handledegeri2 = each;
            }
        }
        driver.switchTo().window(handledegeri2);
        softAssert.assertEquals(driver.getTitle(), "New Window","yeni sayfa title'i istenenden farkli");

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfadakiYaziElementi, "New Window","Ikinci sayfadaki yazi istenenden farkli");
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(windowhandle1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","ilk sayfanin title'i beklenen gibi degil");
        softAssert.assertAll();

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
