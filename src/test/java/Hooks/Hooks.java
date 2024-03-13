package Hooks;

import Pages.BasePage;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;


public class Hooks extends BasePage {


    Login login = new Login();
    ;

    public Hooks() {
        super(driver);
    }


    @Before
    public void antes() throws IOException, InterruptedException {


        login.login();
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

        // driver.quit();
        //driver=null;


    }


}
