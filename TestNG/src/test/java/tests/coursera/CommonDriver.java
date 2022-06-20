package tests.coursera;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CommonDriver {
    private WebDriver driver;
    private int pageloadTimeout;
    private int elementDetectionTimeout;
    private String currentWorkingDriectory;
    WebDriverBrowser browser =new WebDriverBrowser();

    public CommonDriver() throws Exception {
        pageloadTimeout = 60;
        elementDetectionTimeout = 10;
        currentWorkingDriectory = System.getProperty("user.dir");
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

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageloadTimeout = pageLoadTimeout;
    }

    public void navigateToFirstUrl(String url) throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        url = url.trim();
        driver.get(url);
    }
    public String getTitle() throws Exception {
        String title = driver.getTitle();
        return title;
    }


    public String getCurrentUrl() throws Exception {

        return driver.getCurrentUrl();
    }


    public String getPageSource() throws Exception {

        return driver.getPageSource();
    }


    public void navigateToUrl(String url) throws Exception {

        url = url.trim();
        driver.navigate().to(url);

    }


    public void navigateForward() throws Exception {
        driver.navigate().forward();

    }


    public void navigateBackward() throws Exception {
        driver.navigate().back();

    }


    public void refresh() throws Exception {
        driver.navigate().refresh();

    }


    public void closeBrowser() throws Exception {

        if (driver != null) {
            driver.close();

        }
    }


    public void closeAllBrowsers() throws Exception {
        if (driver != null) {
            driver.quit();
        }

    }
}
