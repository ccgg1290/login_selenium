package Steps;

import Pages.ExtractoPorProducto;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Step {

    ExtractoPorProducto extracto=new ExtractoPorProducto();

    @Given("Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto")
    public void que_el_cliente_se_encuentra_en_el_modulo_de_consultas_y_extractos_en_el_submodulo_extracto_por_producto() throws IOException, InterruptedException {
        System.out.println("Given");
    }
    @When("El usuario llena el formulario y da click en boton mostrar datos")
    public void el_usuario_llena_el_formulario_y_da_click_en_boton_mostrar_datos(DataTable dataTable) throws IOException, InterruptedException {
     //  List<Map<String, String>> data = dataTable.asMaps();
      //extracto.descargarExtracto(data);
        System.out.println(System.getProperty("download.default_directory"));
    }
    @Then("Deberia ver el extracto en la pantalla")
    public void deberia_ver_el_extracto_en_la_pantalla() {

        System.out.println(System.getProperty("download.default_directory"));
       // isPresentFile(1,System.getProperty("download.default_directory"));
    }
    @Then("Al darle click en el boton descargar deberia descargarse el extracto")
    public void al_darle_click_en_el_boton_descargar_deberia_descargarse_el_extracto() {
        System.out.println("Then");

    }
}
