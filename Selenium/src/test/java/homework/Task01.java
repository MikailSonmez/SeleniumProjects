package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {

    public static void main(String[] args) {
        // 1-driver olusturalim
        // 2-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        // 3-driver'in tum ekrani kaplamasini saglayalim
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        // 4-https://github.com/ adresine gidelim
        chrome.get("https://github.com/");
        String chromeUrlGithup= chrome.getCurrentUrl();
        String testWordGithup = "github";

        if (chromeUrlGithup.contains(testWordGithup)){
            System.out.println("Chrome Test Githup contains word Pass");
        } else {
            System.out.println("Chrome Test Github contains word Failed");
        }
        System.out.println(chrome.getCurrentUrl());
        // 5-Ardindan https://www.hepsiburada.com/ adrsine gidelim
        chrome.get("https://www.hepsiburada.com/");
        // 6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim
        String chromeTitleHepsiburada = chrome.getTitle();
        String chromeUrlHepsiburada=  chrome.getCurrentUrl();

        String testWord = "burada" ;

        if (chromeTitleHepsiburada.contains(testWord)&&chromeUrlHepsiburada.contains(testWord)){

            System.out.println("Chrome title and url Test Pass");
        } else {
            System.out.println("Chrome title and url Test Failed");
        }

        // 7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim
        chrome.navigate().back();
        // 8-Son adim olarak butun sayfalarimizi kapatmis olalim.
        chrome.close();
    }
}
