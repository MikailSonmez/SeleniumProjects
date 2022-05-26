package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //  driver.get("https://www.amazon.com");
    }

    @AfterClass
    public void tearDown() {
         driver.close(); // buna gore kapanip acilir
    }


    public void tumSayfaScreenShot() throws IOException {


        TakesScreenshot tss = (TakesScreenshot) driver;
        String tarih = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());

        File allPage = new File("target//screenShot/allPage"+tarih+".jpg");

        File geciciImage = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciImage, allPage);
    }
}
