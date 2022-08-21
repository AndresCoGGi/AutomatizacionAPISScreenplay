package co.com.lulobank.certificacion.stepdefinitions;

import co.com.lulobank.certificacion.tasks.ConsumirApiMetodoDelete;
import co.com.lulobank.certificacion.tasks.ConsumirApiMetodoGet;
import co.com.lulobank.certificacion.util.RecursosUtilidad;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EliminarEmpleadoStepDefinitions {

    @Cuando("el realiza la peticion a la Api de {string} con id {string} para eliminar")
    public void elRealizaLaPeticionALaApiDeConIdParaEliminar(String accion, String idEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                ConsumirApiMetodoDelete.conElRecurso(RecursosUtilidad.ObtenerRecurso(accion,idEmpleado)));
    }

    @Entonces("el podra visualizar una respuesta exitosa de eliminacion {string}")
    public void elPodraVisualizarUnaRespuestaExitosaDeEliminacion(String mensajeEliminacion) {
        assertThat(SerenityRest.lastResponse().path("status").toString(), equalTo("success"));
        assertThat(SerenityRest.lastResponse().path("message").toString(), equalTo(mensajeEliminacion));
    }
}
