package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void handleWindows() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println("ilk sayfanin window handle degeri :" + driver.getWindowHandle());
        String windowhandleAmazon = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        driver.manage().window().maximize();
        System.out.println("ikinci sayfanin handle degeri " + driver.getWindowHandle());
        String windowhandleBestBuy = driver.getWindowHandle();


        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        Set<String> handledegerleri = driver.getWindowHandles();
        System.out.println(handledegerleri);
        // amazonun acik olduug sayfaya gecin ve nutella icin arama yapin
        driver.switchTo().window(windowhandleAmazon);
        WebElement aramaKutusuAmazon = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusuAmazon.sendKeys("Nutella", Keys.ENTER);

        // bestbuya gecin ve titlenin Best Buy oldugunu kontrol edin
        driver.switchTo().window(windowhandleBestBuy);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // facebook un acik oldugu sayfaya gecin
        // ve url in https://www.facebook.com oldugunu test edin

        handledegerleri=driver.getWindowHandles();

        // eger acik olan poencerelerden sadece birtanesinin windowhandle degeri bilinmiyorsa
        // 1 ve 2 sitenin handle degerini biliytoruz nset imizi olusturup olmayan handle degeri 3. sayfanin dege4ri olmadigi icin
        // onunla karsilastirilir
        String windowHandleDegeriFacebook ="";
        for(String each: handledegerleri){
            if(!(each.equals(windowhandleAmazon)||each.equals(windowhandleBestBuy))){
                windowHandleDegeriFacebook =each;
            }
        }
        System.out.println(windowHandleDegeriFacebook);
        System.out.println(handledegerleri);
        driver.switchTo().window(windowHandleDegeriFacebook);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Thread.sleep(5000);


    }

    @AfterClass
    public void teardown() {

    }
}
