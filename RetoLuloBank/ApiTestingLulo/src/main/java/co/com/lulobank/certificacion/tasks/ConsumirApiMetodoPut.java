package co.com.lulobank.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

public class ConsumirApiMetodoPut implements Task {
    private String recurso;

    public ConsumirApiMetodoPut(String recurso) {
        this.recurso = recurso;
    }

    public static ConsumirApiMetodoPut conElRecurso(String recurso){
        return Tasks.instrumented(ConsumirApiMetodoPut.class, recurso);
    }

    @Step("{0} consumir api con metodo put")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(recurso));
    }
}
