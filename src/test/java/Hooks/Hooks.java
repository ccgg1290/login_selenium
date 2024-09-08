package Hooks;

import Pages.BasePage;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Pages.BasePage.driver;


public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }


    @Before
    public void antes() throws IOException, InterruptedException {
        TestConfigurationBrowser conf = new TestConfigurationBrowser();
        driver=conf.webDriverManager();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("Scenario fallando, referirse a la imagen adjunta.");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot of the error");
            System.out.println("finalizamos");

        }

        driver.quit();
    }


}
