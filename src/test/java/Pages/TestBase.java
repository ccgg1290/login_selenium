package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		// MyInputFileClass();
		FileInputStream fstream = new FileInputStream("C:\\Tools2023\\EclipseProjects\\eclipse-workspace\\CucumberFramework\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fstream);
		String url = prop.getProperty("QAUrl");
		System.out.println("URL : " + url);
		String stbrowserprop = prop.getProperty("browser");
		String stbrowserdrv;
		
		// Get the browser name from maven system parameter
		String stbrowserMaven = System.getProperty("browser");
		
		// Verify if parameter browser was entry in commnand line
		String stbrowser = stbrowserMaven!=null? stbrowserMaven : stbrowserprop;
		
		
		if(driver == null) {
			if(stbrowser.equalsIgnoreCase("chrome")) {
				System.out.println("2-Type Browser: " + stbrowser);
				stbrowserdrv = prop.getProperty("browserdriver1");
			    System.setProperty("webdriver.chrome.driver",stbrowserdrv);
			    driver = new ChromeDriver();
			}
			if(stbrowser.equalsIgnoreCase("firefox")) {
			    // firefox code
				stbrowserdrv = prop.getProperty("browserdriver2");
				System.setProperty("webdriver.gecko.driver",stbrowserdrv);
				driver = new FirefoxDriver();
			}
			// Setup the timeout for display elements
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			// Get the URL
		    driver.get(url);
		}
	    return driver;
	}
}
