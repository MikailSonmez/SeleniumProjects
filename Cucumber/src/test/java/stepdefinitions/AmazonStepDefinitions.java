package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPages;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {

    AmazonPages amazonPages=new AmazonPages();

    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
    }

    @Given("iPhone icin arama yapar")
    public void i_phone_icin_arama_yapar() {
        amazonPages.aramaKutusu.sendKeys("iPhone" + Keys.ENTER);

    }
    @Then("sonuclarin iPhone icerdigini test eder")
    public void sonuclarin_iphone_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("iPhone"));
    }

    @Given("tea pot icin arama yapar")
    public void tea_pot_icin_arama_yapar() {
        amazonPages.aramaKutusu.sendKeys("tea pot" + Keys.ENTER);
    }

    @Then("sonuclarin tea pot icerdigini test eder")
    public void sonuclarin_tea_pot_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("tea pot"));
    }

    @Given("flower icin arama yapar")
    public void flower_icin_arama_yapar() {
        amazonPages.aramaKutusu.sendKeys("flower" + Keys.ENTER);
    }

    @Then("sonuclarin flower icerdigini test eder")
    public void sonuclarin_flower_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("flower"));
    }

    @Given("{string} icin arama yapar")
    public void icin_arama_yapar(String arananKelime) {

        amazonPages.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

    }
    @Then("sonuclarin {string} icerdigini test eder")
    public void sonuclarin_icerdigini_test_eder(String arananKelime) {
        String sonucYazisiStr=amazonPages.sonucYazisiElementi.getText();
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
    }


    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String istenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));

    }
}
