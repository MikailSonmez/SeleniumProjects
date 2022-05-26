package tests.day13;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload

    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //        - https://the-internet.herokuapp.com/download adresine gidelim.
    //        - code.txt dosyasını indirelim
    //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void isExistTest() {
        //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\practise.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='practise.txt']")).click();
        Thread.sleep(5000);


    }
}
