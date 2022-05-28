package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_YanlisKeyKullanimi {


    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("HMYCurl"));
        // eger key olarak girdigimiz string configration.properties dosyasinda yoksa
        // Configreader.getpropery o key i bulamaz
        // ve nullPointer exceptipn firlatir

    }


}
