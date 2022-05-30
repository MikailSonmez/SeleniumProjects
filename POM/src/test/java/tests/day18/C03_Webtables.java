package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;

import java.util.List;

public class C03_Webtables {

    HotelMyCampPage hotelMyCampPage;
    HMCWebTablePage hmcWebTablePage;

    @Test
    public void loginT(){

        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hotelMyCampLogin();
    }

    @Test
    public void table(){

        hmcWebTablePage=new HMCWebTablePage();
        List<WebElement> headerDataList= hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi : " + headerDataList);

        System.out.println(hmcWebTablePage.tumBodyWebElementi.getText());
        // eger bodyyi tek bir webelement olarak locate edersek
        // icindeki tum datalari getText() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil
        // bodynin icindeki tek bir stringin parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamin mumkun olmaz
        // sadece contains methodu ile bodyde olup olmadiklarini test edebiliriz

        // eger her bir datayi ayri ayri almak istersek
        // //tbody//td seklinde locate edip bir list'e atabiliriz

        List<WebElement> bodyTumDataList=hmcWebTablePage.tumBodyDatalariList;

        System.out.println("body'deki data sayisi : " + bodyTumDataList.size());
    }

    @Test
    public void printRows(){

    }

}
