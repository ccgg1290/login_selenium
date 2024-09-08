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
import static Interactions.WindowsManager.selectNewWindow;


@Slf4j
public class Login extends BasePage {


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
    @FindBy(name = "btInrgesar")
    private WebElement botonIngresar;
    @FindBy(id = "Header_ClientName")
    private WebElement homePage;
    @FindBy(id = "Header_ClientCompanies")
    private WebElement banco;

    public Login() {
        super(driver);
    }
    public Login(WebDriver driver) {
        super(driver);
    }
    public void login(String user) throws IOException, InterruptedException {

        PageFactory.initElements(driver, this);

        navigateTo(environmentManager());
        refreshBrowser();
        FindFluentWait(grupoEmpresarial, 120,5000);
        EnterTheValue(grupoEmpresarial,"23534");
        //FindFluentWait(listaTipoDocumento, 120,10);
        Select objSelect = new Select(listaTipoDocumento);
        objSelect.selectByVisibleText("Cédula de Ciudadanía");
        //selectFromDropdownByValue(listaTipoDocumento,"Cédula de Ciudadanía");
        FindFluentWait(numeroDocumento, 120,5000);
        EnterTheValue(numeroDocumento,user);
        FindFluentWait(clave, 60,10);
        EnterTheValue(clave,"976431");
        FindFluentWait(token, 60,10);
        EnterTheValue(token,"123456");
        FindFluentWait(botonIngresar, 60,10);
        clickOn(botonIngresar);
        selectNewWindow(driver);
        selectFromDropdownByValue(banco,"FALABELLA DE COLOMBIA S.A");


    }
}
