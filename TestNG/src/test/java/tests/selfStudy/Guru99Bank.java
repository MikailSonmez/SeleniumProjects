package tests.self_study;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Guru99Bank extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //1-https://www.demo.guru99.com/V4/ adresine gidiniz
        driver.get("https://www.demo.guru99.com");
        Actions actions =new Actions(driver);
        //2-Acilan sayfada ki EmailID kutusuna faker ile bir email adresi yazdirin
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='emailid']"));
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        Faker faker=new Faker();
        String email = faker.internet().emailAddress();

        actions.click(emailBox).sendKeys(email).click(submit).perform();
        //driver.findElement(By.xpath("//span[text()='Accept All']")).click();

        // driver.findElement(By.xpath("//span[text()='Reject All']")).click();
//YARIM KALDI
    }

}
