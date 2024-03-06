package Hooks;

import Pages.Login;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import Exception.EnvironmentNoFound;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Slf4j
public class TestConfigurationEnvironment {


	public static String ambiente;

	public static String environmentManager() throws IOException, EnvironmentNoFound {


		if (System.getProperty("ambiente") == null) {
			log.info("abriremos ambiente por defecto");
			ambiente= "https://www.google.com";
		}
		else if (System.getProperty("ambiente").equalsIgnoreCase("QA")) {
			log.info("abriremos ambiente QA");
			ambiente= "https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx";
		}
		else{
			//log.info("No especifico un ambiente valido");

            throw new EnvironmentNoFound("Ambiente especificado no existe");


		}

        return ambiente;
    }
}
