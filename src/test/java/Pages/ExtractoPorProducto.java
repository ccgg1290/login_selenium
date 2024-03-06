package Pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


@Slf4j
public class ExtractoPorProducto extends BasePage{

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

    public ExtractoPorProducto() {
        super(driver);
    }


    public void descargarExtracto(List<Map<String, String>> data) throws IOException, InterruptedException {


        PageFactory.initElements(driver, this);
        log.info("******************inicio Extracto por producto Slf4j*******************");
        //logger.info("******************inicio extracto log4fj*******************");
        //*********** LOGIN ****************
        consutasYExtractos.click();
        extractoPorProducto.click();
        Select listaTipoProducto = new Select(listaDeProductos);
        listaTipoProducto.selectByVisibleText(data.get(0).get("TipoProducto"));
        Select listaNombreProducto = new Select(tipoCuenta);
        listaNombreProducto.selectByVisibleText(data.get(0).get("Producto"));
        btnMostrarDatos.click();
        btnDescargar.click();
        log.info("***** Fin Extracto por producto Sfl4j******");
        //logger.info("******************fin  extracto log4fj*******************");


        //driver.close();

        //driver.quit();


    }








}
