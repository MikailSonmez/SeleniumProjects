package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {

    @Test
    public void test01(){
        // dosya yolu ve sayfa ismi verilen bir excel sheet'i map olarak kaydeden
        // reusable bir method olusturalim

        String path="src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";
        // System.out.println(ReusableMethods.mapOlustur(path,sayfaAdi));
        Map<String,String> ulkelerMap= ReusableMethodsExcel.mapOlustur(path,sayfaAdi);

        // olusturdugumuz map'i kullanarak Turkey'in bilgilerini yazdirin

        System.out.println(ulkelerMap.get("Turkey"));

        // listede netherlands oldugunu test edin

        Assert.assertTrue(ulkelerMap.containsKey("Netherlands"));


    }
}
