package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_E2ETesting {

    HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void beforeMethodLoginHotel() {
        hotelmycampPage.hotelMyCampLogin();
    }

    @Test
    public void createHotel() throws InterruptedException {
        hotelmycampPage.testData();
        Actions actions = new Actions(Driver.getDriver());

        for (String each : hotelmycampPage.listData()) {
            hotelmycampPage.addusernamebox.clear();
            hotelmycampPage.addusernamebox.sendKeys(each);
            actions.sendKeys(Keys.END).perform();
            hotelmycampPage.saveclickbutton.click();
            Thread.sleep(3000);
            WebElement errorWord = Driver.getDriver().findElement(By.xpath("//span[@for='UserName']"));
            softAssert.assertTrue(errorWord.isDisplayed());

            Thread.sleep(2000);
            actions.sendKeys(Keys.HOME).perform();
            //span[text()='Please select a username']
        }
    }
    @Test
    public void passwordnegativetest() throws InterruptedException {
        hotelmycampPage.testData();
        Actions actions1 = new Actions(Driver.getDriver());
        for (String each : hotelmycampPage.passwordData()) {
            hotelmycampPage.adUserpasswordbox.clear();
            hotelmycampPage.adUserpasswordbox.sendKeys(each);
            actions1.sendKeys(Keys.END).perform();
            hotelmycampPage.saveclickbutton.click();
            WebElement errorWord = Driver.getDriver().findElement(By.xpath("//span[@for='txtPassword']"));
            softAssert.assertTrue(errorWord.isDisplayed());

            Thread.sleep(2000);
            actions1.sendKeys(Keys.HOME).perform();
            //span[text()='Please select a username']
        }

    }

    @Test
    public void emailnegativetest() throws InterruptedException {
        hotelmycampPage.emaillistData();
        Actions actions1 = new Actions(Driver.getDriver());
        for (String each : hotelmycampPage.emaillistData()) {
            hotelmycampPage.adUseremailbox.clear();
            hotelmycampPage.adUseremailbox.sendKeys(each);
            actions1.sendKeys(Keys.END).perform();
            Thread.sleep(1000);
            hotelmycampPage.saveclickbutton.click();
            WebElement errorWord = Driver.getDriver().findElement(By.xpath("//span[@for='Email']"));
            softAssert.assertTrue(errorWord.isDisplayed());

            Thread.sleep(2000);
            actions1.sendKeys(Keys.HOME).perform();
            //span[text()='Please select a username']
        }

    }

}
