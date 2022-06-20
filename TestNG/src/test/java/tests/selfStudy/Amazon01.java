package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import java.time.Duration;
import java.util.List;

public class Amazon01 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
    }

    @Test
    public void allElementTest(){
        WebElement allElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(allElement);
        List <WebElement> allList = select.getOptions();
        for (WebElement each:allList){
            System.out.println(each.getText());
        }
        int actual = allList.size();
        int expectedSize = 65;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual,expectedSize,"beklenen sayi 65 ama sonuc 65 degil");
        softAssert.assertAll();
    }
}
