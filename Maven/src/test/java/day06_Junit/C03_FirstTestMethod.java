package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_FirstTestMethod {

    WebDriver driver;
    @Test
    public void test01(){
        // amazon.com'a gidelim ve Title'in "amazon" icerdigini test edelim
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";

        /*
        if (actualTitle.contains(arananKelime)){
            System.out.println("amazon test passed");
        } else {
            System.out.println("amazon test failed");
        }

         */
        Assert.assertTrue(actualTitle.contains(arananKelime));
        }

    @Test
    public  void test02(){
       // google'a gidelim ve basligin "google" icerdigini test edelim
        driver.get("https://www.google.com/");
        String actualSayfaTtile=driver.getTitle();
        String arananKelime="Google";

        if (actualSayfaTtile.contains(arananKelime)){
            System.out.println("title test passed");
        } else {
            System.out.println("title test failed");
        }
    }

    @Before
    public void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public  void ortaligiTopla(){
    driver.close();
    }

}
