package Questions;


import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class  IsPresentFile {


  public static Boolean isPresentFile(int fileQuantity, String ruta) {

      int filesQuantity=fileQuantity-1;
      File folder=new File(ruta);

      File[] listaofFiles=folder.listFiles();
      for (File archivo:listaofFiles){
          log.info("Nombre archivo: "+archivo.getName());
      }
      log.info("Numero de archivos = "+listaofFiles.length);
      return listaofFiles.length>filesQuantity;

  }

}
