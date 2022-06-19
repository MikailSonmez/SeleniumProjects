package FreeStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F01 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.co.uk/"); // anasayfa giris


        driver.manage().window().fullscreen();

       driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click();
       driver.manage().window().maximize();


       driver.findElement(By.id("ap_email")).sendKeys("mikail4458@hotmail.com"); // username yazma

       driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();// username giris click
        Thread.sleep(2000);
        driver.findElement(By.id("ap_password")).sendKeys("2020heyo"); // password yazma

        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();//pasword giris click butonu yani
        driver.navigate().to("https://www.amazon.co.uk/");
        driver.get("https://www.amazon.co.uk/");
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();// aranacak kelimeyi yazdiktan sonra search butonu tiklama


        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")).click();
        driver.findElement(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_234")).sendKeys("Turkey");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId_203\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Micheal");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("yesiltepe");
        Thread.sleep(2000);
        driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("malatya");
        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("0400");
        Thread.sleep(2000);
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("457856");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();
    }
}
