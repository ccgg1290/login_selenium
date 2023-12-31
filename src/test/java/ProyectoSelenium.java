import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ProyectoSelenium {


    WebDriver driver;


    @Test
    public void test() throws InterruptedException {
      //File file=new File("C:\\Users\\ccgualterosg\\Documents\\proyectos ejemplo\\Manejo-de-archivos-main\\src\\test\\resources\\prueba.txt");
      //String path =file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting.values.notifications",2);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "C:\\Users\\gualterosg\\Documents");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);
        options.addArguments("ignore-certificate-errors");
        driver = new ChromeDriver(options);
    //*********** LOGIN ****************
      driver.get("https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx");
      //driver.findElement(By.id("file-upload")).sendKeys(path);
        //Thread.sleep(5000);
      driver.findElement(By.id("tbGrupoEmpresarial")).sendKeys("23534");
      //driver.findElement(By.id("ddlTipoID")).sendKeys("hahahaha");
      Select objSelect =new Select(driver.findElement(By.id("ddlTipoID")));
      objSelect.selectByVisibleText("Cédula de Ciudadanía");
      driver.findElement(By.name("tbNumeroID")).sendKeys("1049653008");
      driver.findElement(By.name("tbClavePersonal")).sendKeys("976431");
      driver.findElement(By.name("tbToken")).sendKeys("123456");
      String oldTab = driver.getWindowHandle();
      driver.findElement(By.name("btInrgesar")).click();
      //driver.findElement(By.name("lbNombreUsuario")).click();
      //String LBERROR=driver.findElement(By.id("lbError")).getText();
      //String text =driver.findElement(By.id("uploaded-files")).getText();
      //assertEquals(LBERROR,"Los datos ingresados no son válidos.");
        Thread.sleep(20000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(newTab.size());
        driver.switchTo().window(newTab.get(1));
        //WebDriverWait wait= new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("lbNombreUsuario")));
        //System.out.println(""+nameUser);
        String HOME_PAGE=driver.findElement(By.id("lbNombreUsuario")).getText();
        assertEquals(HOME_PAGE,"Dayana Andrea Rojas Alba");

        Select empresa =new Select(driver.findElement(By.id("dropMasterEmpresa")));
        empresa.selectByVisibleText("FALABELLA DE COLOMBIA S.A");
        //************** FIN LOGIN **************
        //EXTRACTO POR PRODUCTO

        driver.findElement(By.linkText("Consultas y Extractos")).click();
        driver.findElement(By.linkText("Extracto por Producto")).click();

        Select listaTipoProducto =new Select(driver.findElement(By.id("cphCuerpo_ddlTipoProducto")));
        listaTipoProducto.selectByVisibleText("CUENTA AHORROS BANCO FALABELLA");

        Select listaNombreProducto =new Select(driver.findElement(By.id("cphCuerpo_ddlNombreProducto")));
        listaNombreProducto.selectByVisibleText("116060084657");

        driver.findElement(By.id("cphCuerpo_btMostrarDatos")).click();

        //Thread.sleep(2000);
        driver.findElement(By.id("cphCuerpo_btDescargar")).click();
        driver.findElement(By.id("cphCuerpo_btDescargar")).sendKeys("C:\\Users\\ccgualterosg\\Documents\\fallabella_cristian");
        driver.findElement(By.id("cphCuerpo_btDescargar")).click();
        System.out.println("antes");
        //driver.findElement(By.id("cphCuerpo_btDescargar")).click();
        //driver.findElement(By.id("cphCuerpo_btDescargar")).sendKeys("C:\\Users\\ccgualterosg\\Documents");
        //driver.findElement(By.id("cphCuerpo_btDescargar")).click();
        System.out.println("despues");

        File folder=new File("C:\\Users\\ccgualterosg\\Documents\\fallabella_cristian");
        File[] listaOfFiles=folder.listFiles;



    }
}
