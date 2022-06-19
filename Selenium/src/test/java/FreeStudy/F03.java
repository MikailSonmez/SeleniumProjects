package FreeStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F03 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver() ;


        driver.get("https://www.amazon.co.uk/");// ana sayfa giris
        driver.manage().window().fullscreen();

        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();// sign sayfasina giris

        driver.findElement(By.id("ap_email")).sendKeys("mhmetaliszgn@gmail.com"); ;// username yazma
        //username yazma id si           // kendi username iniz
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();// username giris click

        driver.findElement(By.id("ap_password")).sendKeys("ervanaz2012"); ;//password yazma
        //password yazma id si               kendi sifreniz
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();//pasword giris click butonu yani
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"); ;
        //aramabutonu id si                         aramak istediginiz obje
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();// aranacak kelimeyi yazdiktan sonra search butonu tiklama

        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")).click();
        driver.findElement(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")).click();
        driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_234")).sendKeys("Slovenia");
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode-dropdown-nativeId_203\"]")).click();

        driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("Mehmet Ali Sezgin");
        driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Podmilscakova ulica 18");
        driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Ljubljana");
        driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("1000");
        driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("0038630335147");
        driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")).click();

    }
}