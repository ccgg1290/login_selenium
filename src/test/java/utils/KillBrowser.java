package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class KillBrowser {

    private KillBrowser() {
        throw new IllegalStateException("Utility class");
    }

    public static final Logger loggertest = LoggerFactory.getLogger(KillBrowser.class);

    public static void processes(String browser) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", browser + ".exe");
        Process process = processBuilder.start();
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            loggertest.debug("Procesos del browser cerrados exitosamente");
            //System.out.println("sout Procesos del browser cerrados exitosamente");
        } else {
            //System.out.println("sout No existen procesos del browser o no fue posible cerrarlos");
            loggertest.debug("No existen procesos del browser o no fue posible cerrarlos");
        }
    }
}
