package Pages;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Exception.EnvironmentNoFound;

import java.io.IOException;
import java.util.ArrayList;

import static Hooks.TestConfigurationEnvironment.environmentManager;
import static org.junit.Assert.assertEquals;



@Slf4j
public class Login extends BasePage {





   //public WebDriver driver;


    @FindBy(id = "tbGrupoEmpresarial")
    private WebElement grupoEmpresarial;
    @FindBy(id = "ddlTipoID")
    private WebElement listaTipoDocumento;
    @FindBy(name = "tbNumeroID")
    private WebElement numeroDocumento;
    @FindBy(name = "tbClavePersonal")
    private WebElement clave;
    @FindBy(name = "tbToken")
    private WebElement token;
    @FindBy(id = "lbNombreUsuario")
    private WebElement homePage;
    @FindBy(id = "dropMasterEmpresa")
    private WebElement banco;

    public Login() {
        super(driver);
    }
    public void login() throws IOException, InterruptedException {

        System.out.println("directorio por defecto:"+System.getProperty("download.default_directory"));
        PageFactory.initElements(driver, this);

        //logger1.info("pruebaaaaaaaaaaaaaaa");
        log.info("****************** inicio Slf4j    *******************");
        //logg.info("******************inicio Slf4j base page   *******************");
        logger.info("******************inicio log4fj    *******************");
        //*********** LOGIN ****************
        //navigateTo("https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx");

        navigateTo(environmentManager());

        driver.navigate().refresh();
        //esperar 20 segundos que aparezca el elemento,asi se que ya estoy en el home page del usuario
       // Thread.sleep(10000);
        //elementIsDisplayed(grupoEmpresarial);
        grupoEmpresarial.sendKeys("23534");
        Select objSelect = new Select(listaTipoDocumento);
        objSelect.selectByVisibleText("Cédula de Ciudadanía");
        numeroDocumento.sendKeys("1049653008");
        clave.sendKeys("976431");
        token.sendKeys("123456");
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.name("btInrgesar")).click();
        //Thread.sleep(20000);

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(newTab.get());
        driver.close();
        System.out.println("numero de navegadores"+ newTab.size());
        driver.switchTo().window(newTab.get(1));
        //driver.switchTo().window(newTab.remove(0));
        //espera 20 segundos
        //Thread.sleep(10000);
        Find(homePage);
        Find(homePage,60,5);
        String home_page = homePage.getText();
        assertEquals(home_page, "Dayana Andrea Rojas Alba");

        Select empresa = new Select(banco);
        empresa.selectByVisibleText("FALABELLA DE COLOMBIA S.A");

        //logg.info("****************** fin login Slf4j *******************");
       // logger.info("****************** fin login  log4fj *******************");
        //driver.quit();

    }
}
