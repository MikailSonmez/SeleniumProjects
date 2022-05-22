package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_ManageWindowGet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Amazon sayfasina gidelim. https://www.Amazon.com/
        driver.get("https://www.Amazon.com/");
        //3. sayfainin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //4. sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //6. sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("For maximize position : " + driver.manage().window().getPosition());
        System.out.println("For maximize size : " + driver.manage().window().getSize());
        //7. sayfayi fullscreen yapin
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        //8. sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen maximize position : " + driver.manage().window().getPosition());
        System.out.println("Fullscreen maximize size : " + driver.manage().window().getSize());
        //9. sayfayi kapatin
        driver.close();
    }
}
