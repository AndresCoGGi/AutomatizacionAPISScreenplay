package co.com.lulobank.certificacion.models;

public class Empleado {

    private String nombre;
    private String salario;
    private String edad;

    public Empleado(String nombre, String salario, String edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalario() {
        return salario;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", salario='" + salario + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }
}
