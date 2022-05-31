package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {

    @Test
    public void test01() throws IOException {
        // ulkeler exceline 5.sutun olarak NUFUS sutunu ekleyelim
        // 3. satirdaki ulkenin nufusunu 1000000 yapalim

        // 1- dosyaya ulasalim
        String path="src/test/java/resources/yerine gelcek excel.xlsx";
        FileInputStream fis = new FileInputStream(path);
        // 2- class'da calismak icin dosyanin bir kopyasi olan workbook olusturalim
        Workbook workbook= WorkbookFactory.create(fis);

        // 3- dosyada yapmak istedigimiz degisiklikleri yapalim
        // ilk satirin 5. hucresine NUFUS basligini yazdirdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        // 3. satirdaki ulkenin nufusunu 1000000 yapalim

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        // 4. kopyada yaptigimiz degisiklikleri ana dosyaya kaydedelim
        // excelin kapali oldugundan emin olun yoksa bozulur
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);
    }
}
