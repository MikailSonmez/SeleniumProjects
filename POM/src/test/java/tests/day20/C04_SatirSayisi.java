package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_SatirSayisi {

    @Test
    public void test01() throws IOException {

        // ulkeler excelindeki Sayfa1 ve Sayfa2'deki satir sayilarini
        // ve kullanilan satir sayilarini bulun

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);

        int sayfaSatirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfaFizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        System.out.println("1. sayfa satir sayisi : " + sayfaSatirSayisi); // 190
        System.out.println("1. sayfa fiziki kullanilan satir sayisi : " + sayfaFizikiKullanilanSatirSayisi); // 191
        // fiziki kullanilan satir sayisi index ile degil sayma sayilari ile calisir

        int sayfa2SatirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
        int sayfa2FizikiKullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("1. sayfa satir sayisi : " + sayfa2SatirSayisi); // 23
        System.out.println("1. sayfa fiziki kullanilan satir sayisi : " + sayfa2FizikiKullanilanSatirSayisi); // 8
    }
}
