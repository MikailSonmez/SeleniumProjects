package day04_XpathCssSelectore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // 1. Bir class oluşturun : AmazonSearchTest
       // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
       // a.google web sayfasına gidin. https://www. amazon.com/
        driver.get("https://www.amazon.com/");
       // b. Search(ara) “city bike”
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
       // c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement sonucYazisiElementi=driver.findElement(By.className("sg-col-inner"));
        // WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        // classname ile daha once bu elementi locate edemedigimiz halde
        // xpath ile clas attribute'unu kullanarak locate edebildik
        System.out.println(sonucYazisiElementi.getText());
       // d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        /*
        WebElement ilkUrunResmi= driver.findElement(By.className("s-image"));
        ilkUrunResmi.click();
        */
        // e. sadece click yapmak gibi basir bir islemde kullanacagimiz webelementler icin
        // variable olusturmadan direkt locate edip, istedigmiz islemi yapabiliriz
        driver.findElement(By.className("s-image")).click();



    }
}
