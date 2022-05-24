package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//● Bir class oluşturun: C3_DropDownAmazon
public class C04_DropDown {
    WebDriver driver;
    WebElement dropdownElementi;
    Select select;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void Test1(){
    //Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);

        List<WebElement> optionListesi=select.getOptions();

        int actualOptionSayisi=optionListesi.size();
        int expectedOptionSayisi=45;

        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi);
    }

    @Test
    public void test2(){
    //Test 2
    //1. Kategori menusunden Books secenegini secin
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));


    //2. Arama kutusuna Java yazin ve aratin
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
    //3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    //4. Sonucun Java kelimesini icerdigini test edin
        String actualSonucSayisiYazisi=sonucSayisiElementi.getText();
        String arananKelime="Java";

        Assert.assertTrue(actualSonucSayisiYazisi.contains(arananKelime),"arama sonucu Java icermiyor");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
