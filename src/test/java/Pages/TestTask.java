package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class TestTask  {
	public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getGrupoEmpresarial() {
        return grupoEmpresarial;
    }

    public void setGrupoEmpresarial(WebElement grupoEmpresarial) {
        this.grupoEmpresarial = grupoEmpresarial;
    }

    @FindBy(id = "tbGrupoEmpresarial")
    private WebElement grupoEmpresarial;
   // private String searchButton = "//input[@id='nav-search-submit-button']";

	public TestTask(WebDriver driver) {
		this.driver = driver;

    }

	public WebDriver taskLogin() throws IOException, InterruptedException {


        PageFactory.initElements(driver, this);


		//*********** LOGIN ****************
		driver.get("https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx");
		driver.navigate().refresh();
		driver.findElement(By.id("tbGrupoEmpresarial")).sendKeys("23534");
        Select objSelect = new Select(driver.findElement(By.id("ddlTipoID")));
		objSelect.selectByVisibleText("Cédula de Ciudadanía");
		driver.findElement(By.name("tbNumeroID")).sendKeys("1049653008");
		driver.findElement(By.name("tbClavePersonal")).sendKeys("976431");
		driver.findElement(By.name("tbToken")).sendKeys("123456");
		String oldTab = driver.getWindowHandle();
        driver.findElement(By.name("btInrgesar")).click();
        Thread.sleep(20000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(newTab.size());
        driver.switchTo().window(newTab.get(1));
        String HOME_PAGE = driver.findElement(By.id("lbNombreUsuario")).getText();
        assertEquals(HOME_PAGE, "Dayana Andrea Rojas Alba");
        Select empresa = new Select(driver.findElement(By.id("dropMasterEmpresa")));
        empresa.selectByVisibleText("FALABELLA DE COLOMBIA S.A");
        //************** FIN LOGIN **************
        //EXTRACTO POR PRODUCTO
        Thread.sleep(5000);
        driver.findElement(By.linkText("Consultas y Extractos")).click();
        driver.findElement(By.linkText("Extracto por Producto")).click();
        Select listaTipoProducto = new Select(driver.findElement(By.id("cphCuerpo_ddlTipoProducto")));
        listaTipoProducto.selectByVisibleText("CUENTA AHORROS BANCO FALABELLA");
        Select listaNombreProducto = new Select(driver.findElement(By.id("cphCuerpo_ddlNombreProducto")));
        listaNombreProducto.selectByVisibleText("116060084657");
        driver.findElement(By.id("cphCuerpo_btMostrarDatos")).click();
        driver.findElement(By.id("cphCuerpo_btDescargar")).click();
        System.out.println("antes");
        System.out.println("despues");
        Thread.sleep(5000);

        driver.quit();
	    return driver;
	}
}
