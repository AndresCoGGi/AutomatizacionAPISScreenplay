package co.com.lulobank.certificacion.tasks;

import co.com.lulobank.certificacion.models.Empleado;
import co.com.lulobank.certificacion.util.LeerArchivoUtilidad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class ConsumirApiCreacionEmpleados implements Task {

    private String recurso;
    private Empleado empleado;

    public ConsumirApiCreacionEmpleados(String recurso, Empleado empleado) {
        this.recurso = recurso;
        this.empleado = empleado;
    }

    public static ConsumirApiCreacionEmpleados conLaInformacion(String recurso, Empleado empleado) {
        return Tasks.instrumented(ConsumirApiCreacionEmpleados.class, recurso, empleado);
    }

    @Step("{0} consumir Api creacion empleados")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(recurso)
                .with(request -> request
                        .body(LeerArchivoUtilidad
                                .retornarStringJson("./src/test/resources/peticionesjson/crearempleado.json")
                                        .replace("NuevoNombre", empleado.getNombre())
                                        .replace("NuevoSalario", empleado.getSalario())
                                        .replace("NuevaEdad", empleado.getEdad()))
                ));
    }
}
