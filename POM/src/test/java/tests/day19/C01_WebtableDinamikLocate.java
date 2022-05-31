package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebtableDinamikLocate {
    // 3 test methodu olusturalim
    // 1. method satir numarasi verdigimde bana o satirdaki datalari yazirsin
    // 2. method satir no ve data numarasi girdigimde verdigim dtayi yazdirsin
    // 3. method sutun numarsi verdigimde bana tum sutunu yazdirsin

    HMCWebTablePage hmcWebTablePage;
    HotelMyCampPage hotelMyCampPage;
    @Test
    public void satirYazdirTesti(){
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hotelMyCampLogin();

        hmcWebTablePage=new HMCWebTablePage();
        WebElement ucuncusatirElementi=hmcWebTablePage.satirYazdir(3);

        System.out.println(ucuncusatirElementi.getText());

        Driver.closeDriver();

    }

    @Test
    public void hucreGetirTesti(){
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hotelMyCampLogin();
        hmcWebTablePage=new HMCWebTablePage();

        System.out.println("giridigniz hucredeki element : " +hmcWebTablePage.hucreWebElementGetir(3,5));
    }

    @Test
    public void sutunYazdirTesti(){
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hotelMyCampLogin();
        hmcWebTablePage=new HMCWebTablePage();
        hmcWebTablePage.sutunYazdir(4);

        Driver.closeDriver();
    }
}
