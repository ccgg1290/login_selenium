package Interactions;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

@Slf4j
public class WindowsManager {


  private final WebDriver driver;

    public WindowsManager(WebDriver driver) {
        this.driver = driver;
    }

    public static void selectNewWindow(WebDriver driver) {
    //String oldTab = driver.getWindowHandle();
    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    //System.out.println("navegadoes"+newTab.size());
    driver.close();
    driver.switchTo().window(newTab.get(1));
    newTab.remove(newTab.get(0));
    log.info("Se selecciona nueva ventana del navegador");
    //System.out.println("navegadoes"+newTab.size());

  }

}
