package Pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;


public class ProyectoSelenium {


    WebDriver driver;

    TestTask1 task;


    @Test
    public void test() throws InterruptedException, IOException {
        //File file=new File("C:\\Users\\ccgualterosg\\Documents\\proyectos ejemplo\\Manejo-de-archivos-main\\src\\test\\resources\\prueba.txt");
        //String path =file.getAbsolutePath();
        Properties properties = System.getProperties();
        System.out.println("antes: " + properties.getProperty("webdriver.driver"));
        TestConfiguration conf = new TestConfiguration();
        driver=conf.WebDriverManager();
        task=new TestTask1(driver);
        task.taskLogin();

    }
}
