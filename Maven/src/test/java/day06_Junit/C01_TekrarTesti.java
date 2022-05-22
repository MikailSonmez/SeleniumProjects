package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.google.com/ gidin
        driver.get("https://www.google.com/");
        // cookies uyarisini kabul ederek kapatin
       // cookiesi almanca cozer //driver.findElement(By.xpath(//div[text()='Ich stimme zu']")).click();
        // sayfa basliginin "Google" ifadesi icerdigni test edin
        String actualSayfaTtile=driver.getTitle();
        String arananKelime="Google";

        if (actualSayfaTtile.contains(arananKelime)){
            System.out.println("title test passed");
        } else {
            System.out.println("title test failed");
        }
        // arama cubuguna "Nutella" yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // bulunan sonuc sayisini yazdirin

        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisiElementi.getText());
        // sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String sonucSayisiString=sonucSayisiElementi.getText();
        String sonucKelimeleri[]=sonucSayisiString.split(" ");
        String sonucNutellaSayisiString=sonucKelimeleri[1]; // 213.000.000
        sonucNutellaSayisiString=sonucNutellaSayisiString.replace(".","");

        int nutellaAramaSonucu=Integer.parseInt(sonucNutellaSayisiString);

        if (nutellaAramaSonucu>10000000){
            System.out.println("Nutella arama testi passed");
        } else {
            System.out.println("Nutella arama testi failed");
        }
        // sayfayi kapatin
        driver.close();
    }
}
