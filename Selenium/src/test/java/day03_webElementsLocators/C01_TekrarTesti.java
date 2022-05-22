package day03_webElementsLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. youtube sayfasina gidin sayfa basliginin "youtube" olup olmadigni dogrulayin(verify),
        // eger degilse dogru basligi(actual title) konsolda yazdirin
        driver.navigate().to("https://www.youtube.com");
        String actualTitleYoutube=driver.getTitle();
        String expectedYoutubeTitle="youtube";

        if (actualTitleYoutube.equals(expectedYoutubeTitle)){
            System.out.println("youtube title test is passed");
        } else {
            System.out.println("youtube title test is failed\nactual page title is : " + actualTitleYoutube);
        }
        //3. sayfa url'sinin "youtube icerip icermedigini (contains) dogrulayin,
        // icermiyorsa dogru url'yi yazdirin
        String actualYoutubeUrl=driver.getCurrentUrl();
        String arananKelimeYoutubeUrl="youtube";
        if (actualYoutubeUrl.contains(arananKelimeYoutubeUrl)){
            System.out.println("youtube Url test is passed");
        } else {
            System.out.println("Youtube Url test is failed \nActual Youtube url : " + actualYoutubeUrl);
        }
        //4. daha sonra amazon sayfasina gidin
        driver.navigate().to("https://www.amazon.com");
        //5. youtube sayfasine geri gidin
        driver.navigate().back();
        //6. sayfay yenileyin
        driver.navigate().refresh();
        //7. amazon sayfasina donun
        driver.navigate().forward();
        //8. sayfayi tam sayfa yapin
        driver.manage().window().fullscreen();
        //9. ardindan sayfa basliginin "Amazon icerip icermedigini(contains) dogrulayin
        // yoksa dogru basligi (Actual Title) yazdirin
        String actualAmazonTitle= driver.getTitle();
        String amazonTitleArananKelime="Amazon";

        if (actualAmazonTitle.contains(amazonTitleArananKelime)){
            System.out.println("amazon title test is passed");
        } else {
            System.out.println("amazon title test is failed \nActual amazon title : " + actualAmazonTitle);
        }
        //10. sayfa url'sinin https://www.amazon.com/ olup olmagidini dorulaiyn
        // degilse dogru Url'yi yazdirin

        String expectedAmazonUrl="https://www.amazon.com/";
        String actualAmazonUrl= driver.getCurrentUrl();

        if (expectedAmazonUrl.equals(actualAmazonUrl)){
            System.out.println("amazon Url test is passed");
        } else {
            System.out.println("amazon Url test is faile \nActual amazon URL is : " + actualAmazonUrl);
        }
        //11. sayfayi kapatin
        driver.close();
    }
}
