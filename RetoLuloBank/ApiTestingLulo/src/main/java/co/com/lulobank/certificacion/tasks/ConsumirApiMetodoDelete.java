package co.com.lulobank.certificacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class ConsumirApiMetodoDelete implements Task {

    private String recurso;

    public ConsumirApiMetodoDelete(String recurso) {
        this.recurso = recurso;
    }

    public static ConsumirApiMetodoDelete conElRecurso(String recurso){
        return Tasks.instrumented(ConsumirApiMetodoDelete.class, recurso);
    }

    @Step("{0} consumir api con metodo delete")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(recurso));
    }

}
