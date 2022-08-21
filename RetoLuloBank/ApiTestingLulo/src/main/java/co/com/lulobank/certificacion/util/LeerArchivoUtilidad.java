package co.com.lulobank.certificacion.util;

import java.io.File;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerArchivoUtilidad{

    private static final Logger LOGGER = LoggerFactory.getLogger(LeerArchivoUtilidad.class);

    public static String retornarStringJson(String route) {
        String line = "";
        Scanner input;
        try {
            input = new Scanner(new File(route));
            while (input.hasNextLine()) {
                line = line + input.nextLine();
            }
            input.close();
        } catch (Exception e) {
            LOGGER.error("Error occurred while trying return file", e);
        }
        return line;
    }

}
