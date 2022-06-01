package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageFirstClass {
    //POM de farkli class lara farkli sekilde ulasilmasi benimsenmistir
    // Driver class i icinde static yontemi kullaniyoruz
    // Page classlari icin ise obje uzerinden kullanilmasi tercih edilmistir

    @Test
    public void test01() {
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //arama kutusuna Nutella yazip aratalim

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella", Keys.ENTER);

        // arama sonuclarinin nutela icerdigini test edelim

        String actualSonucStr = amazonPage.sonucyazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Nutella"));

    }
    @Test(groups = {"miniRegression","smoke"})
    public void test02(){
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Java", Keys.ENTER);

        String actualSonucStr = amazonPage.sonucyazisiElementi.getText();
        Assert.assertTrue(actualSonucStr.contains("Java"));
    }

}
