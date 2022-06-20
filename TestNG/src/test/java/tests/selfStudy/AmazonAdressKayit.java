package tests.selfStudy;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class AmazonAdressKayit extends TestBase {

    @Test
    public void inception() throws  InterruptedException{
        driver.get("https://amazon.com");

        WebElement x = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions = new Actions(driver);
        actions.moveToElement(x).perform();

        WebElement signIn = driver.findElement(By.className("nav-line-1-container"));
        signIn.click();

        WebElement signInButton = driver.findElement(By.id("ap_email"));
        signInButton.sendKeys("gurutechproeducation@gmail.com", Keys.ENTER);

        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("guru2022", Keys.ENTER);
        WebElement bekleme = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

        //Not: Log in olduktan sonra amazon giris sayfasina yonlendirilirsiniz
        //•	Hello guru kutusunun uzerine gelin ve imleci 2 sn bekletin
        actions.moveToElement(bekleme).perform();
        Thread.sleep(2000);
        //•	Account a tiklayin ve acilan sayfanin altinda
        driver.findElement(By.xpath("(//span[@class='nav-text'])[4]")).click();
        //•	Your adress sayfasina gidin
        WebElement yourAdresses = driver.findElement(By.xpath("//a[text()='Your addresses']"));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        yourAdresses.click();
        //•	Add adres e click yapin
        driver.findElement(By.id("ya-myab-plus-address-icon")).click();
    }

    @Test
    public void Test1() throws IOException, InterruptedException {

        driver.get("https://amazon.com");

        WebElement x = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions = new Actions(driver);
        actions.moveToElement(x).perform();

        WebElement signIn = driver.findElement(By.className("nav-line-1-container"));
        signIn.click();

        WebElement signInButton = driver.findElement(By.id("ap_email"));
        signInButton.sendKeys("gurutechproeducation@gmail.com", Keys.ENTER);

        WebElement passwordButton = driver.findElement(By.xpath("//input[@type='password']"));
        passwordButton.sendKeys("guru2022", Keys.ENTER);
        WebElement bekleme = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        //Not: Log in olduktan sonra amazon giris sayfasina yonlendirilirsiniz
        //•	Hello guru kutusunun uzerine gelin ve imleci 2 sn bekletin
        actions.moveToElement(bekleme).perform();
        Thread.sleep(2000);
        //•	Account a tiklayin ve acilan sayfanin altinda
        driver.findElement(By.xpath("(//span[@class='nav-text'])[4]")).click();
        //•	Your adress sayfasina gidin
        WebElement yourAdresses= driver.findElement(By.xpath("//a[text()='Your addresses']"));
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        yourAdresses.click();
        //•	Add adres e click yapin
        driver.findElement(By.id("ya-myab-plus-address-icon")).click();

//(//span[@class='a-list-item'])[1]

        ///////////////////////////////////////////////////////////////////////////////////////

        //Test Case 1
        //Country/Region:Slovenia
        WebElement dropdownElementi= driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']"));
        Select select=new Select(dropdownElementi);
        select.selectByVisibleText("Slovenia");
        //Full name : Mahmut Mehmet
        //  Actions actions=new Actions(driver);
        WebElement name= driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']"));
        actions.click(name).sendKeys("Mahmut Mehmet")
                //Street address: Mahmutpasa
                .sendKeys(Keys.TAB).sendKeys("Mahmutpasa")
                //City:Ljubljana
                .sendKeys(Keys.TAB).sendKeys("Ljubljana")
                //Zip Code:60100
                .sendKeys(Keys.TAB).sendKeys("60100")
                //Phone Number +38669645099
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("+38669645099").perform();
        //Datalari girdikten sonra ve kayit ettikten sonra screenshot alin
        screenShot();
        //Datalarini girin add address butonuna tiklayin ve asagidaki uyarinin verildigini test edin
        WebElement addAdressButon= driver.findElement(By.xpath("(//input[@class='a-button-input'])[3]"));
        actions.click(addAdressButon).perform();
        //“We couldn't verify your address. Please make sure it's correct before you save it”.
        WebElement uyarıYazısı= driver.findElement(By.xpath("(//div[@class='a-section'])[4]"));

        String actualText= uyarıYazısı.getText();
        String expectedText="We couldn't verify your address. Please make sure it's correct before you save it.";

        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void Test2() throws InterruptedException, IOException {
        //   Amazon sayfasi Adres Sayfasi Testi
        //   1-•	www.amazon.com adresine gidin


        //     •	Hello sign in kutusu uzerinde imlecinizi 2 sn bekletin ve acilan kutudan sign-in a gidin
        //   Userid: gurutechproeducation@gmail.com yazin ve log in olun
        //   pass: guru2022 ile giris yapin
//
        //   Not: Log in olduktan sonra amazon giris sayfasina yonlendirilirsiniz
        //   •	Hello guru kutusunun uzerine gelin ve imleci 2 sn bekletin

     /*   WebElement halloGuru= driver.findElement(By.xpath("Hello, guru"));
        Actions actions =new Actions(driver);
        actions.moveToElement(halloGuru);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        //   •	Account a tiklayin ve acilan sayfanin altinda
        actions.sendKeys(Keys.PAGE_DOWN).perform();*/

        driver.get("https://amazon.com");


        //   •	Your adress sayfasina gidin
        Actions actions =new Actions(driver);
        driver.findElement(By.xpath("//a[text()='Your addresses']")).click();

        //   •	Add adres e click yapin
        driver.findElement(By.xpath("//h2[text()='Add Address']")).click();

        //   Test Case 2
        //   Country/Region:Turkey
        WebElement land= driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']"));
        Select select = new Select(land);
        select.selectByVisibleText("Turkey");

        //   Full name : Mahmut Mehmet
        actions.sendKeys(Keys.TAB).sendKeys("Mahmut Mehmet").
                //   Street address: Mahmutpasa
                        sendKeys(Keys.TAB).sendKeys("Mahmutpasa").sendKeys(Keys.TAB).
                //   City:Ljubljana
                        sendKeys(Keys.TAB).sendKeys("Ljubljana").sendKeys(Keys.TAB).
                //   Zip Code:1000
                        sendKeys(Keys.TAB).sendKeys("1000").
                //   Phone Number +38669645099
                        sendKeys(Keys.TAB).sendKeys("+38669645099").perform();
        //   Datalarini girin
        //   Datalari girdikten sonra ve kayit ettikten sonra screenshot alin
        driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();

        //   Please enter a valid ZIP or postal code. Ve Please provide a valid phone number uyarilarini aldiginizi test edin.
        WebElement zipUyari = driver.findElement(By.xpath("(//div[text()='Please enter a valid ZIP or postal code.'])[1]"));
        TakesScreenshot tss = (TakesScreenshot) driver;
        File webelementSS=  new File("target/screenShot/zip.jpeg");
        File geciciResim=zipUyari.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webelementSS);

        WebElement phonnumberUyari= driver.findElement(By.xpath("//div[text()='Please provide a valid phone number']"));
        TakesScreenshot tss1 = (TakesScreenshot) driver;
        File webelementSS1=  new File("target/screenShot/phone.jpeg");
        File geciciResim1=phonnumberUyari.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim1,webelementSS1);
    }

    @Test
    public void Test3() throws IOException, InterruptedException {

        driver.findElement(By.xpath("//a[@id='ya-myab-address-edit-btn-0']")).click(); // adress  Edit butonu
        WebElement city = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']"));
        city.sendKeys("Ljubljana");
        Thread.sleep(2000);
        screenShot();
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[3]")).click();
        Thread.sleep(2000);
        screenShot();
        WebElement adressKayitMesaji = driver.findElement(By.tagName("h4"));
        String adresSonuc = adressKayitMesaji.getText();
        Assert.assertNotEquals(adresSonuc, "Adress Saved");


    }
    @Test
    public void Test4() throws IOException, InterruptedException {
        WebElement newAdresElementi = driver.findElement(By.xpath("//div[@id='ya-myab-plus-address-icon']"));
        newAdresElementi.click();
        WebElement countryElementi = driver.findElement(By.xpath("(//span[@class='a-button-text a-declarative'])[1]"));

        Actions actions = new Actions(driver);
        actions.click(countryElementi).keyDown("S").keyDown("L").sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        WebElement nameElementi = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']"));
        nameElementi.clear();
        actions.click(nameElementi).sendKeys("Mahmut Mehmet").perform();

        WebElement phoneElementi = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']"));
        actions.sendKeys("+38669645099").sendKeys(Keys.TAB).sendKeys("Mehmet ali pasa cad.  ")
                .sendKeys(Keys.TAB).sendKeys("puskullu sok. 34/3").sendKeys(Keys.TAB).sendKeys("Istanbul")
                .sendKeys(Keys.TAB).click().sendKeys("L").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys("1000")
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        screenShot();
    }

    public void screenShot() throws IOException {
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaSS = new File("target/screenShot/tumsayfa.png");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, tumSayfaSS);

    }

}
