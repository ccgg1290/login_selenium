package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Pages",
                "Steps"},
        //plugin = { "pretty", "html:target/cucumber-reports"},
        //plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:output/report.html"}
        //plugin = {"pretty",
          //      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            //    "timeline:test-output-thread/" }
        plugin= {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:reportecucumber//report.html"}
       // monochrome = true

)
public class Runner {










}
