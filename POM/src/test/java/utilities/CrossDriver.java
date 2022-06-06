package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){ // ozel yaptik
    }
    public static WebDriver driver; // ozel yaptik


    public static WebDriver getDriver(String browser){
        // buraya parametre olarak yazdigimiz browser sayedinde
        // coklu testler, calistirilirken arada CrossDriver'a yeni
        // browser atamasi yapabilmemize imkan tanimasi icindir

        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        WebDriverManager.chromedriver().setup();
        if (driver==null){ // bu if sayesinde kod calisirken bir kere new koyword ile driver olusuturulacak
            // diger kullanimlarda new devreye girmeyecek
            switch (browser){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.chromedriver().setup();
                    driver=new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.chromedriver().setup();
                    driver=new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
