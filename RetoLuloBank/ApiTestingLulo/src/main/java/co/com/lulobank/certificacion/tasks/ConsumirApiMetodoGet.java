package co.com.lulobank.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class ConsumirApiMetodoGet implements Task {

    private String recurso;

    public ConsumirApiMetodoGet(String recurso) {
        this.recurso = recurso;
    }
    public static ConsumirApiMetodoGet conElRecurso(String recurso){
        return Tasks.instrumented(ConsumirApiMetodoGet.class, recurso);
    }

    @Step("{0} consumir api con metodo get")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(recurso));
    }
}