package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-reports.html",
                "json:target/json-reports/Pcucumber1.json",
                "junit:target/xml-report/Pcucumber1.xml"},
        features="src/test/resources/features",
        glue = "stepdefinitions",
        tags="@Automation",
        dryRun = false
)

public class Runner {
    // Runner class'inin body'sine hicbir kod yazmiyoruz
    // bu class icin onemli olan kullanacagimiz 2 adet notasyon

    //dryRun=false yazildiginda belirlenen tag'la etiketlenen tum scenario'lari sirasiyla calistirir
    //dryRun=true dedigimizde ise kodlari calistirmadan eksik stepler olup olmadigini kontrol eder
    // ve varsa bize eksik stepleri rapor eder
}
