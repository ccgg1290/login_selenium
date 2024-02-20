package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestConfiguration {
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {

		// Edge
		if(System.getProperty("webdriver.driver")==null){
			System.out.println("ni modo");

		}
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		else if (System.getProperty("webdriver.driver").equalsIgnoreCase("edge")) {
			Properties propiedades = System.getProperties();
			System.out.println("antes: " + propiedades.getProperty("webdriver.driver"));
			System.out.println("Estas son las propiedades " + propiedades.get("webdriver.base.url"));


			//WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			HashMap<String, Object> edgePrefs = new HashMap<>();
			//edgePrefs.put("download.default_directory", Paths.get("C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\Proyectos probar\\login-selenium\\src\\test\\resources\\archivos").toAbsolutePath().toString());
			edgePrefs.put("download.default_directory", "C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\Proyectos para probar\\login-selenium\\src\\test\\resources\\archivos");
			options.setExperimentalOption("prefs", edgePrefs);
			options.addArguments("ignore-certificate-errors");
			driver = new EdgeDriver(options);
		}

		// FIREFOX
		else if (System.getProperty("webdriver.driver").equalsIgnoreCase("firefox")) {
			Properties propiedades = System.getProperties();
			System.out.println("antes: " + propiedades.getProperty("webdriver.driver"));
			System.out.println("Estas son las propiedades " + propiedades.get("webdriver.base.url"));

			//WebDriverManager.firefoxdriver().setup();
			System.out.println("mitad " + propiedades.getProperty("webdriver.driver"));
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("browser.link.open_newwindow", 3);
			options.addPreference("browser.link.open_newwindow.restriction", 0);
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", "C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\Proyectos para probar\\login-selenium\\src\\test\\resources\\archivos");
			driver = new FirefoxDriver(options);
			System.out.println("despues " + propiedades.getProperty("webdriver.driver"));

		}
		else if (System.getProperty("webdriver.driver").equalsIgnoreCase("chrome")) {
			//chrome
			// System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			Properties propiedades = System.getProperties();
			System.out.println("antes: " + propiedades.getProperty("webdriver.driver"));
			System.out.println("Estas son las propiedades " + propiedades.get("webdriver.base.url"));


			//WebDriverManager.chromedriver().setup();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_setting.values.notifications", 2);
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", "C:\\Users\\gualterosg\\Documents");

			chromePrefs.put("download.default_directory", Paths.get("").toAbsolutePath().toString());
			chromePrefs.put("download.default_directory", "C:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\Proyectos para probar\\login-selenium\\src\\test\\resources\\archivos");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromePrefs);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("ignore-certificate-errors");
			driver = new ChromeDriver(options);
		}













	    return driver;
	}
}
