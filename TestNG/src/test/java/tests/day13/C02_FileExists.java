package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists{
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.home"));
        // masaustundeki deneme klasorunun path ini istesem
        //"C:\Users\mikai\Desktop\Deneme\selenium.xlsx"
        // masaustunde klasor ve excell dosya olmazsa olmaz yarin bakarsam hatirlatir bu
        String path = System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.xlsx";
        System.out.println(path);
        System.out.println("user.dir :" + System.getProperty("user.dir"));

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        String pomPath = System.getProperty("user.dir") + "\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));


        // masaustunde data klasoru icinde sselenium.xlsx dosyasinin oldugunu test edin
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim.
    }
}
