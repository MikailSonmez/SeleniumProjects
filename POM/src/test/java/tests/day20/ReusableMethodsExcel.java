package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReusableMethodsExcel {
    // bir method olusturalim
    // dosya yolu, sayfa ismi satir ve hucre indexini verince hucre bilgisini yazdirsin

    public static Cell hucreGetir(String path, String sayfaIsmi, int satirIndex, int hucreIndex){
            Cell cell=null;
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(fileInputStream);
            cell=workbook.getSheet(sayfaIsmi).getRow(satirIndex).getCell(hucreIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cell;
    }

    public static Map<String,String> mapOlustur(String path, String sayfaAdi) {

        Map<String,String> excelMap=new HashMap();
        // Map<String,String> excelMap=new TreeMap<>(); sirali getirir yavastir
        Workbook workbook;
        // ilk adim excele ulasmak
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook=WorkbookFactory.create(fis);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();
        String key ="";
        String value="";

        for (int i=0 ; i<=satirSayisi ;i++){

            // ikinci adim tablodaki hucreleri map'e uygun hale donusturmek
            key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
            value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString() +
                    workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString() +
                        workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();
            // ucuncu adim key value haline getirdigimiz satirlari map'e eklemek
            excelMap.put(key,value);
        }

        return excelMap;
    }
}
