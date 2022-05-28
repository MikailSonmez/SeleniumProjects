package tests.day17;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_SingletonPattern {



    @Test
    public void test01(){
        // singelton patter bir class dan birden fazla obje uretilmesine izin vermeyen bir pattern olarak
        // kabul gormustur
        // biz driver class ini driver uretmek usere kullaniyoruz
        // ancak Driver class inda driver isminde bir instance variable da var
        // ve biz obje ureterek bu instance driver a ulasabilirz

        //  Driver driver1 =new Driver();
        //  Driver driver2 =new Driver();
        //  Driver driver1 =new Driver();
        //  driver1.driver.get("");

        // singleton pattern kabul gormus bir pattern dir
        // amac bir class dan obje uretilmmemesi saglamaktir
        // bunun icin singleton pattern

    }
}
