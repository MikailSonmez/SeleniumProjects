package day05_mavenProjectCreate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //Soru 2
    //1. http://zero.webappsecurity.com sayfasina gidin
    //2. Signin buttonuna tiklayin
    // 3. Login alanine “username” yazdirin
    //4. Password alanine “password” yazdirin
    //5. Sign in buttonuna tiklayin
    //6. Pay Bills sayfasina gidin
    //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //8. tarih kismina “2020-09-10” yazdirin
    //9. Pay buttonuna tiklayin
    //10. “The payment was successfully submitted.” mesajinin ciktigini control edin



    }
}
