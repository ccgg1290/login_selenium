package Pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


@Slf4j
public class TestTask1 {
    public WebDriver driver;

    public TestTask1(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


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
    @FindBy(linkText = "Consultas y Extractos")
    private WebElement consutasYExtractos;
    @FindBy(linkText = "Extracto por Producto")
    private WebElement extractoPorProducto;
    @FindBy(id = "cphCuerpo_ddlTipoProducto")
    private WebElement listaDeProductos;
    @FindBy(id = "cphCuerpo_ddlNombreProducto")
    private WebElement tipoCuenta;
    @FindBy(id = "cphCuerpo_btMostrarDatos")
    private WebElement btnMostrarDatos;
    @FindBy(id = "cphCuerpo_btDescargar")
    private WebElement btnDescargar;


    public WebDriver taskLogin() throws IOException, InterruptedException {


        PageFactory.initElements(driver, this);
        log.info("******************inicio*******************");
        //*********** LOGIN ****************
        driver.get("https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx");
        driver.navigate().refresh();
        grupoEmpresarial.sendKeys("23534");
        Select objSelect = new Select(listaTipoDocumento);
        objSelect.selectByVisibleText("Cédula de Ciudadanía");
        numeroDocumento.sendKeys("1049653008");
        clave.sendKeys("976431");
        token.sendKeys("123456");
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.name("btInrgesar")).click();
        Thread.sleep(20000);

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(newTab.size());
        driver.switchTo().window(newTab.get(1));

        String HOME_PAGE = homePage.getText();
        assertEquals(HOME_PAGE, "Dayana Andrea Rojas Alba");

        Select empresa = new Select(banco);
        empresa.selectByVisibleText("FALABELLA DE COLOMBIA S.A");

        Thread.sleep(5000);
        consutasYExtractos.click();
        extractoPorProducto.click();

        Select listaTipoProducto = new Select(listaDeProductos);
        listaTipoProducto.selectByVisibleText("CUENTA AHORROS BANCO FALABELLA");

        Select listaNombreProducto = new Select(tipoCuenta);
        listaNombreProducto.selectByVisibleText("116060084657");

        btnMostrarDatos.click();
        btnDescargar.click();
        Thread.sleep(5000);

        log.info("***** Fin ******");

        driver.quit();

        return driver;
    }
}
