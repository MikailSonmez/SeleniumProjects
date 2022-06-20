package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonDrivers {

    private WebDriver driver;
    private int pageloadTimeout;
    private int elementDetectionTimeout;
    private String currentWorkingDriectory;
    WebDriverBrowser browser ;
    WebDriverWait wait;
    SoftAssert softAssert;


    public CommonDrivers() throws Exception {
        pageloadTimeout = 15;
        elementDetectionTimeout = 10;
        currentWorkingDriectory =System.getProperty("user.dir");

        if (browser.equals("chrome")) {
            System.getProperty(" WebDriverManager.chromedriver().setup()", currentWorkingDriectory +
                    "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            System.getProperty("WebDriverManager.edgedriver().setup()", currentWorkingDriectory +
                    "/drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Invalid Browser Type");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }




    public WebDriver getDriver() {
        return driver;
    }

    public int getPageloadTimeout() {
        return pageloadTimeout;
    }

    public int getElementDetectionTimeout() {
        return elementDetectionTimeout;
    }

    public String getCurrentWorkingDriectory() {
        return currentWorkingDriectory;
    }

    public WebDriverBrowser getBrowser() {

        return browser;
    }

    public WebDriverWait getWait() {

        return wait;
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

}
