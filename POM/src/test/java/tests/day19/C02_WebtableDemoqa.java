package tests.day19;

import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebtableDemoqa {


    @Test
    public void demoqaTest(){
        //1.
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));

        DemoqaPage demoqaPage=new DemoqaPage();
        //2.
        // normalde //thead/th olurdu ancak bu tablo class isimleri ile organiz eedilmis
        System.out.println("baslik  satiri elementi : " + demoqaPage.baslikSatiriElementi.getText());
        // basliklarWebElementListesi bu sekilde de yazdirilabilir

        //3.
        System.out.println("3. sutun basligi : " + demoqaPage.basliklarWebElementListesi.get(2).getText());

        //4.
        System.out.println("==========Tum Body===========");
        System.out.println(demoqaPage.bodyTekWebElementi.getText());

        //5.
        System.out.println("Tablodaki data sayisi : "+demoqaPage.tumDataWebElementList.size());

        //6.
        System.out.println("Tum satir sayisi : " + demoqaPage.tumSatirlarWebElementList.size());

        //7.
        System.out.println("tablodaki sutun sayisi : " +
                demoqaPage.tumDataWebElementList.size()/demoqaPage.tumSatirlarWebElementList.size());
        //8.
        demoqaPage.sutunYazdir(3);

        //9.
        demoqaPage.ismeGoreMaasYazdir("Kierra");

        //10.

        demoqaPage.hucreYazdir(2,3);


        Driver.closeDriver();

    }
}
