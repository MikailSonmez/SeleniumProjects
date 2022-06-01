package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ResableRunner {

    @Test
    public void test01(){

        // ulkeler excelindeki, Sayfa1'de
        // 11. index'deki satiri, 2. indexdeki hucresinin Azerbaycan oldugunu test edin

        String path="src/test/java/resources/ulkeler.xlsx";
        String expectedData="Azerbaycan";
        String actualData= ReusableMethodsExcel.hucreGetir(path,"Sayfa1",11,2).toString();

        Assert.assertEquals(actualData,expectedData);
    }
}
