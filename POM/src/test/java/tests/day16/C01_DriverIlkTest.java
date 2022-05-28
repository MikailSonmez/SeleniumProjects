package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest {

    // Driver class'i sayesinde bizim eski driver was killed
    // artik driver'a ihtiyac varsa Driver.getDriver() yazacagiz

    @Test
    public void test01(){
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // amazona gittigimizi test edelim
        String actualTitle=Driver.getDriver().getTitle();
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains("Amazon"));

        // Driver.getDriver method'u her calistiginda
        // driver= new ChromeDriver(); komutundan oturu yeni bir driver olusturuyor
        // Biz Driver class'dan getDriver'i ilk calistirdigimizda new atamasi olsun
        // sonraki calistirmalarda atama olmasin istiyoruz
        // bunun icin driver= new ChromeDriver(); satiri bir if blogu icine alacagiz
    }

    @Test
    public void test02(){
        // bestbuy anasayfaya gidelim
        Driver.getDriver().get("https://www.bestbuy.com");

        // bestbuy'a gittigimizi test edelim

        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("bestbuy"));
        Driver.closeDriver();

    }
}
