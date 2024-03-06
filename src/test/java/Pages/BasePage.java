package Pages;

import Hooks.TestConfigurationBrowser;
import Hooks.TestConfigurationEnvironment;
import org.apache.logging.log4j.LogManager;

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


public class BasePage {
    public static WebDriver driver;

    //final static Logger logger1 = LoggerFactory.getLogger(BasePage.class);
    //public final Logger logg= LoggerFactory.getLogger(String.valueOf(BasePage.class));
    public final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BasePage.class);
    private static Actions action;


    WebDriverWait wait;

    static {
        TestConfigurationBrowser conf = new TestConfigurationBrowser();
        try {
            driver = conf.webDriverManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {

        if (url ==null) {
            driver.quit();
        }
        driver.get(url);
    }

    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        ;
    }

    public static void closeBrowser() {
        driver.quit();
    }


    //fluentWait
    public WebElement Find(WebElement elemento,int duracion, int cadaCuanto) {
        Wait<WebElement> fwait= new FluentWait<WebElement>(elemento)
                .withTimeout(java.time.Duration.ofSeconds(duracion))
                .pollingEvery(java.time.Duration.ofMillis(cadaCuanto))
                .ignoring(NoSuchElementException.class);

        boolean elementVisibly=fwait.until(WebElement::isDisplayed);
        if(elementVisibly)
            return elemento;
        else
            throw new NoSuchElementException();
    }


    //explicitwait
    public WebElement Find(WebElement elemento) {


        System.out.println("Hora inicio explicit: "+returnDate());
        //explicit wait, cada elemento que utilice este metodo sera esperado el tiempo establecido
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Hora Final explicit: "+returnDate());
        return wait.until(ExpectedConditions.visibilityOf(elemento));
        //return driver.findElement(By.xpath(locator));
    }


    public WebElement Find(String locator) {

        return driver.findElement(By.xpath(locator));
    }



    public void implicitWait(WebDriver driver) {

        //implicit wait, todos los objetos deben esperar segun lo estabglezcamos aca
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public void clickElement(WebElement elemento) {
        Find(elemento).click();
    }

    public void submitElement(WebElement elemento) {
        Find(elemento).submit();
    }

    public void write(WebElement elemento, String textToWrite) {
        Find(elemento).clear();
        Find(elemento).sendKeys(textToWrite);
    }

    public int dropdownSize(WebElement elemento) {
        Select dropdown = new Select(Find(elemento));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public void selectFromDropdownByValue(WebElement elemento, String valueToSelect) {
        Select dropdown = new Select(Find(elemento));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(WebElement elemento, int valueToSelect) {
        Select dropdown = new Select(Find(elemento));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(WebElement elemento, String valueToSelect) {
        Select dropdown = new Select(Find(elemento));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(WebElement elemento) {
        action.moveToElement(Find(elemento));
    }

    public void doubleClick(WebElement elemento) {
        action.doubleClick(Find(elemento));
    }

    public void rightClick(WebElement elemento) {
        action.contextClick(Find(elemento));
    }

    public String getValueFromTable(String locator, int row, int column) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend) {

        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";

        Find(cellToFill).sendKeys(stringToSend);
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
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(WebElement objeto) {

        return objeto.isDisplayed();
    }

    public boolean elementIsSelected(String locator) {

        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    public void selectNthElementFromList(String locator, int index) {
        List<WebElement> list = driver.findElements(By.className(locator));
        list.get(index).click();
    }

    public void dragAndDrop(String locator, String locator2) {
        WebElement element = Find(locator);
        WebElement element2 = Find(locator2);
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