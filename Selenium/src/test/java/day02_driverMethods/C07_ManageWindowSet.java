package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageWindowSet {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //2. Amazon sayfasina gidelim
        driver.get("https://www.Amazon.com/");
        //3. sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //4. sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(800, 600));
        driver.manage().window().setSize(new Dimension(300, 500));
        //5. sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        int xCoordination = driver.manage().window().getPosition().getX();
        int yCoordination = driver.manage().window().getPosition().getY();
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();

        Thread.sleep(3000);

        if (xCoordination == 800 && yCoordination == 600 && width == 300 && height == 500){
            System.out.println("Olceklendirme testi pass");
        }else {
            System.out.println("Olceklendirme testi failed");

        }
        //6. sayfayi kapatin

        driver.close();
    }
}
