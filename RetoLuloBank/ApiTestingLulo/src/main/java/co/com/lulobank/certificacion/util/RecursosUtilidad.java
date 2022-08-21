package co.com.lulobank.certificacion.util;

public class RecursosUtilidad {

    public static String ObtenerRecurso(String accion, String idEmpleado){
        String recurso;
        switch (accion) {
            case "Consultar empleados":
                recurso = "/api/v1/employees";
                break;
            case "Consultar empleado":
                recurso = "/api/v1/employee/"+idEmpleado;
                break;
            case "Crear empleado":
                recurso = "/api/v1/create";
                break;
            case "Eliminar empleado":
                recurso = "/api/v1/delete/"+idEmpleado;
                break;
            case "Actualizar empleado":
                recurso = "/api/v1/update/"+idEmpleado;
                break;
            default:
                throw new IllegalArgumentException("Accion invalida: " + accion);
        }
        return recurso;
    }

}
