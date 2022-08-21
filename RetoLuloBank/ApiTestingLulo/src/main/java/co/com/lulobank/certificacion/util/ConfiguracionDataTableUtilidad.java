package co.com.lulobank.certificacion.util;

import co.com.lulobank.certificacion.models.Empleado;

import java.util.Map;

public class ConfiguracionDataTableUtilidad {

    public static Empleado retornarObjetoEmpleados(Map<String, String> data){
        Empleado empleado = new Empleado(data.get("nombre"), data.get("salario"),
                data.get("edad"));
        return empleado;
    }

}
