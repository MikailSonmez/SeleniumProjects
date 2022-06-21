package study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get(" http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login alanine  “username” yazdirin
        WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
        user.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='checkbox']")).click(); // checkbox a tiklamak icin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //Not: Bazi pc ler de sistem guvenligi acisindan hata veriyor ilerlemiyor bu sebepten dolayi
        driver.navigate().back();
        // Advanced e tiklayip altinda gelen linke tiklarsak sayfa ilerliyor.
        //driver.findElement(By.xpath("//button[@id='details-button']")).click();
        //driver.findElement(By.id("proceed-link")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("1000000");
        //8. tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement word = driver.findElement(By.xpath("//span[@title='$ 1000000 payed to payee sprint']"));
        String actualWord = word.getText();
        String expectedWord = "The payment was successfully submitted";
        if(actualWord.contains(expectedWord)){
            System.out.println("Title test PASSED");

        }else{
            System.out.println("Title test FAILED");
        }
        // E guvenli cikis yapmak lazim
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_link")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
