

#@ExtactosPorProducto
Feature: Yo como cliente corporativo quiero descargar mi extracto de productos

#*** 1 ****



  @DescargarPdf
  Scenario Outline: Cliente descarga su extracto con exito

    Given Que el cliente se encuentra en el modulo de consultas y extractos en el submodulo Extracto por producto
    When El usuario llena el formulario y da click en boton mostrar datos
      | TipoProducto    |Producto     |Ano |Mes      |
      | <TipoProducto>  |<Producto> |<Ano>|<Mes>|
    Then Deberia ver el extracto en la pantalla
    Then Al darle click en el boton descargar deberia descargarse el extracto

Examples:
| TipoProducto                     |Producto     |Ano |Mes      |
| CUENTA AHORROS BANCO FALABELLA   |116060084657 |2023|Diciembre|
#| CUENTA AHORROS BANCO FALABELLA   |116060084657 |2023|Diciembre|



