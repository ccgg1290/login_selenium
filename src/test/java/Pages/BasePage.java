package Pages;




import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

import static utils.ReturnDate.returnDate;


@Slf4j
public class BasePage {
    public static WebDriver driver;

    //final static Logger logger1 = LoggerFactory.getLogger(BasePage.class);
    //public final Logger logg= LoggerFactory.getLogger(String.valueOf(BasePage.class));
    //public final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BasePage.class);
    private static Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    static WebDriverWait wait;

//    static {
//        TestConfigurationBrowser conf = new TestConfigurationBrowser();
//        try {
//            driver = conf.webDriverManager();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//
//
//    }


    public static void logGetText(WebElement elemento) {
        if (elemento.getAttribute("id") != null) {
            log.info("Se recupero el texto: " + elemento.getText() + " del elemento con id: " + elemento.getAttribute("id"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se recupero el texto: " + elemento.getText() + " del elemento con name: " + elemento.getAttribute("name"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se recupero el texto: " + elemento.getText() + " del elemento con texto de: " + elemento.getAttribute("value"));
        }
    }

    public String getText(WebElement elemento) {
        logGetText(elemento);
        return elemento.getText();

    }

    public void navigateTo(String url) {
        if (url == null) {
            driver.quit();
            log.info("Browser cerrado : " + url);

        }
        driver.get(url);
        log.info("Browser abrierto en la url : " + url);
    }

    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        log.info("Ir al elemento " + linkText);
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void logEnterTheValue(WebElement elemento, String texto) {
        if (elemento.getAttribute("id") != null) {
            log.info("Se ingresa " + texto + " en elemento con ID " + elemento.getAttribute("id"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se ingresa " + texto + " en elemento con name " + elemento.getAttribute("name"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se ingresa " + texto + " en elemento con texto " + elemento.getAttribute("value"));
        }
    }


    public static void EnterTheValue(WebElement elemento, String texto) {
        elemento.sendKeys(texto);
        logEnterTheValue(elemento, texto);


    }


    public static void logElementVisible(WebElement elemento) {
        if (elemento.getAttribute("id") != null) {
            log.info("Elemento con id " + elemento.getAttribute("id") + " esta visibleeee");
        } else if (elemento.getAttribute("name") != null) {
            log.info("Elemento con name " + elemento.getAttribute("name") + " esta visible");
        } else if (elemento.getAttribute("name") != null) {
            log.info("Elemento con texto " + elemento.getAttribute("value") + " esta visible");
        }
    }

    public static void logElementNotVisible(WebElement elemento) {
        if (elemento.getAttribute("id") != null) {
            log.info("Elemento con id NO esta visible" + elemento.getAttribute("id") + " No esta visible");
        } else if (elemento.getAttribute("name") != null) {
            log.info("Elemento con name NO esta visible" + elemento.getAttribute("name") + " No esta visible");
        } else if (elemento.getAttribute("name") != null) {
            log.info("Elemento  con texto " + elemento.getAttribute("value") + " No esta visible");
        }
    }

    //fluentWait
    public WebElement FindFluentWait(WebElement elemento, int duracion, int cadaCuanto) {
        Wait<WebElement> fwait = new FluentWait<WebElement>(elemento)
                .withTimeout(java.time.Duration.ofSeconds(duracion))
                .pollingEvery(java.time.Duration.ofMillis(cadaCuanto))
                .ignoring(NoSuchElementException.class);

        boolean elementVisibly = fwait.until(WebElement::isDisplayed);
        if (elementVisibly) {
            logElementVisible(elemento);
            return elemento;
        } else {
            logElementNotVisible(elemento);
            throw new NoSuchElementException();
        }
    }


    //explicitwait
    public static WebElement find(WebElement elemento) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement elementVisibly = wait.until(ExpectedConditions.visibilityOf(elemento));
        if (elementVisibly != null) {
            //logElementVisible(elemento);
            return elementVisibly;
        } else {
            //logElementNotVisible(elemento);
            throw new NoSuchElementException();
        }
    }


    public WebElement find(String locator) {

        return driver.findElement(By.xpath(locator));

    }

    public void refreshBrowser() {
        driver.navigate().refresh();
        log.info("Refresh Browser");
    }


    public void implicitWait(WebDriver driver) {

        //implicit wait, todos los objetos deben esperar segun lo estabglezcamos aca
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void findAndclickElement(WebElement elemento) {
        find(elemento).click();
        log.info("Click Elemnto. " + elemento);
    }


    public static void logClickOn(WebElement elemento) {
        if (elemento.getAttribute("id") != null) {
            log.info("Click Elemento con id " + elemento.getAttribute("id"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Click Elemento con name " + elemento.getAttribute("name"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Click Elemento en elemento con texto " + elemento.getAttribute("value"));
        }
    }


    public void clickOn(WebElement elemento) {
        elemento.click();
        logClickOn(elemento);
    }


    public void submitElement(WebElement elemento) {
        find(elemento).submit();
    }

    public void write(WebElement elemento, String textToWrite) {
        find(elemento).clear();
        log.info("Se borra el texto del elemento " + elemento);
        find(elemento).sendKeys(textToWrite);
        log.info("Se ingresa: " + textToWrite + " En el elemento: " + elemento);
    }

    public int dropdownSize(WebElement elemento) {
        Select dropdown = new Select(find(elemento));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public static void logDropDown(WebElement elemento, String valueToSelect) {
        if (elemento.getAttribute("id") != null) {
            log.info("Se selecciona el item: " + valueToSelect + " En el dropdown: " + elemento.getAttribute("id"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se selecciona el item: " + valueToSelect + " En el dropdown: " + elemento.getAttribute("name"));
        } else if (elemento.getAttribute("name") != null) {
            log.info("Se selecciona el item: " + valueToSelect + " En el dropdown: " + elemento.getAttribute("value"));
        }
    }

    public static void selectFromDropdownByValue(WebElement elemento, String valueToSelect) {
        Select dropdown = new Select(find(elemento));
        dropdown.selectByVisibleText(valueToSelect);
        logDropDown(elemento, valueToSelect);

    }

    public

    void selectFromDropdownByIndex(WebElement elemento, int valueToSelect) {
        Select dropdown = new Select(find(elemento));
        dropdown.selectByIndex(valueToSelect);
        log.info("Se selecciona el item: " + valueToSelect + " En el dropdown: " + elemento);
    }

    public void selectFromDropdownByText(WebElement elemento, String valueToSelect) {
        Select dropdown = new Select(find(elemento));
        dropdown.selectByVisibleText(valueToSelect);
        log.info("Se selecciona el item: " + valueToSelect + " En el dropdown: " + elemento);
    }

    public void hoverOverElement(WebElement elemento) {
        action.moveToElement(find(elemento));
    }

    public void doubleClick(WebElement elemento) {
        action.doubleClick(find(elemento));
    }

    public void rightClick(WebElement elemento) {
        action.contextClick(find(elemento));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {

        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    public boolean elementEnabled(String locator) {
        return find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(WebElement objeto) {

        return objeto.isDisplayed();
    }

    public boolean elementIsSelected(String locator) {

        return find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    public void selectNthElementFromList(String locator, int index) {
        List<WebElement> list = driver.findElements(By.className(locator));
        list.get(index).click();
    }

    public void dragAndDrop(String locator, String locator2) {
        WebElement element = find(locator);
        WebElement element2 = find(locator2);
        action.dragAndDrop(element, element2).build().perform();
    }

    public void selectCriteriaFromList(String locator, String criteria) {
        List<WebElement> list = driver.findElements(By.className(locator));
        for (WebElement element : list) {
            if (element.getText().equals(criteria)) {
                element.click();
                break;
            }
        }
    }

}