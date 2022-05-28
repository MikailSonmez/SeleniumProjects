package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    // bir page class i actigimizda ilk yapmamiz gerekn sey
    // parametresiz bir constructor olusturup
    // bu constructor icinde page factory ile driver a ilk deger atamasini yapmak olmalidir.


    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        // bizim utilities package icindeki getdriver methodunu imizi bu classda da kullanilir hale getirdi

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucyazisiElementi;
}
