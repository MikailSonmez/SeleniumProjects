package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {
    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement baslikSatiriElementi;

    @FindBy(xpath = "//div[@class='rt-th rt-resizable-header -cursor-pointer']")
    public List<WebElement> basliklarWebElementListesi;

    @FindBy(xpath = "//div[@class='rt-tbody']")
    public WebElement bodyTekWebElementi;

    @FindBy(xpath = "//div[@class='rt-td']")
    public List<WebElement> tumDataWebElementList;

    @FindBy(xpath = "//div[@class='rt-tr-group']")
    public List<WebElement> tumSatirlarWebElementList;

    public void sutunYazdir(int sutun) {
        // ((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[4]
        String dinamikXpath;
        WebElement geciciElement;
        int satirSayisi=tumSatirlarWebElementList.size();
        for (int i=1 ; i<=satirSayisi ; i++){
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+sutun+"]";
            geciciElement=Driver.getDriver().findElement(By.xpath(dinamikXpath));
            System.out.println(geciciElement.getText());
        }
    }

    public void ismeGoreMaasYazdir(String isim) {
        String dinamikXpath;
        int satirSayisi=tumSatirlarWebElementList.size();
        String satirdakiIsim;
        String salary;

        for (int i=1 ; i<satirSayisi ; i++){
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+1+"]";
            satirdakiIsim=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
            dinamikXpath="((//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'])["+5+"]";
            salary=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();

            if (satirdakiIsim.equals(isim)){
                System.out.println(salary);
            }
        }

    }

    public void hucreYazdir(int satir, int sutun) {
        String dinamikXpath="((//div[@class='rt-tr-group'])["+sutun+"]//div[@class='rt-td'])["+satir+"]";
        System.out.println(Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText());
    }
}
