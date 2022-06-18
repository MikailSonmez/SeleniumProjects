package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {

        //        1-driver olusturalim
        //        2-java class'imiza chromedriver.exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

        WebDriver chrome = new ChromeDriver();

        //        3-driver'in tum ekrani kaplamasini saglayalim
        chrome.manage().window().maximize();

        //        4-https://github.com/ adresine gidelim

        chrome.get("https://github.com/");

        //        5-Ardindan https://www.hepsiburada.com/ adrsine gidelim

        chrome.get("https://www.hepsiburada.com/");

        // 6-Title ve url console da yazdirin ve yine title ve url in "burada" kelimesini icerip icermedigini kontrol edelim

        String chromeTitleHepsiBurada = chrome.getTitle();
        String chromeUrlHepsiBurada = chrome.getCurrentUrl();

        String testWord = "burada";

        if (chromeTitleHepsiBurada.contains(testWord)&& chromeTitleHepsiBurada.contains(testWord)){
            System.out.println("Chrome hepsiburada contains 'burada' test PASS");
        } else {
            System.out.println("Chrome hepsiburada contains 'burada' test FAILED");
        }

        //  7-Sonrasinda https://github.com/ adresine geri donelim ve  sayfayi yenileyelim


        chrome.navigate().back();
        Thread.sleep(3000);

        chrome.navigate().refresh();

        //  8-Son adim olarak butun sayfalarimizi kapatmis olalim.
        chrome.close();

    }
}
