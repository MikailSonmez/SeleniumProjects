package day05_relativeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gdiin
        driver.get("https://www.amazon.com/");
        //3- browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- sayfayi "refresh" yapin
        driver.navigate().refresh();
        //5- sayfa basliginda "Spend less" icerdigin test edin
        String actualTitle=driver.getTitle();
        String titleArananKelime="Spend less";

        if (actualTitle.contains(titleArananKelime)){
            System.out.println("Title testi Passed");
        } else {
            System.out.println("Title testi Failed \nActual title : " + actualTitle);
        }
        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
        //7- birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday gift cards'")).click();
        //8- Best Seller bolumunden ilk urunu cagirin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
        //9- Gift card details'den 25$'i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();
        //10- urun ucreti 25 oldugunu test edin
        WebElement fiyatElementi=driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
        String expectedFiyat="$25.00";
        String actualFiyat=fiyatElementi.getText();

        if (expectedFiyat.equals(actualFiyat)){
            System.out.println("fiyat testi passed");
        } else {
            System.out.println("fiyat testi failed");
        }
        //11- sayfayi kapatin
        driver.close();
    }
}
