package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@value='1'])[3]")
    public WebElement facebookCookies;
    @FindBy(name = "email")
    public WebElement emailKutusu;
    @FindBy(id = "pass")
    public WebElement passKutusu;
    @FindBy(name = "login")
    public WebElement loginButonu;
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement goruntulenemediYazisi;


}
