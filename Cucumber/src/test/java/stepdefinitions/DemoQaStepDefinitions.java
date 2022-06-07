package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DemoQaPage;
import utilities.ReusableMethods;

public class DemoQaStepDefinitions {
    DemoQaPage demoQaPage=new DemoQaPage();
    @Then("Will enable {int} seconds butonunun enable olmaisini bekleyin")
    public void will_enable_seconds_butonunun_enable_olmaisni_bekleyin(Integer int1) {

        ReusableMethods.waitForClickablility(demoQaPage.willEnable5SecondsElement, 15);
    }
    @Then("Will enable {int} seconds butonunun enable oldugunu test edin")
    public void will_enable_seconds_butonunun_enable_oldugunu_test_edin(Integer int1) {

        Assert.assertTrue(demoQaPage.willEnable5SecondsElement.isEnabled());

    }
}
