package day03_webElementsLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_LoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz
        driver.get("http://a.testaddressbook.com");
        //b. sign in butonuna basin
        WebElement signInLinki=driver.findElement(By.id("sign-in")); // sadece locate edip bir variable'a assign ettik
        signInLinki.click();
        //c. email textbox,password textbox, and sign in button elementlerini locate ediniz...
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox= driver.findElement(By.id("session_password"));
        WebElement signInButton= driver.findElement(By.name("commit"));
        //d. kullanici adini ve sifreyi asagiya girin ve oturum ac butonuna tiklayin;
        //      1. username: testtechproed@gmail.com
        //      2. password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");

        Thread.sleep(3000);
        signInButton.click();
        //e. expected use id'nin testtechproed@gmail.com oldugunu dogrulayin(verify)
        WebElement girisYazisiElementi=driver.findElement(By.tagName("h1"));
        System.out.println(girisYazisiElementi.getText());
        String actualGirisYazisi=girisYazisiElementi.getText();
        String expectedGirisYazisi="Welcome to Address Book";

        if (actualGirisYazisi.equals(expectedGirisYazisi)){
            System.out.println("Sayfaya giris testi Pass");
        } else{
            System.out.println("Sayfaya giris testi Failed");
        }
        //f. "Addresses" ve "Sign Out" textllerinin goruntulendigini(displayed) dogrulayin(verify)
        WebElement adressWebElementi=driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));

        System.out.println(adressWebElementi.isDisplayed()); // true veya false dondurcek gorundu mu gorunmedi mi

        if (adressWebElementi.isDisplayed()){
            System.out.println("Adress elementi goruntuleme testi pass");
        } else {
            System.out.println("Adress elementi goruntuleme testi failed");
        }

        if (adressWebElementi.isDisplayed()){
            System.out.println("SignOut elementi goruntuleme testi pass");
        } else {
            System.out.println("SignOut elementi goruntuleme testi failed");
        }
        // 3. sayfada kac tane link oldugunu bulun

        List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));

        System.out.println("sayfada " + linklerListesi.size() + " adet link bulunmaktadir");

        driver.close();

    }
}
