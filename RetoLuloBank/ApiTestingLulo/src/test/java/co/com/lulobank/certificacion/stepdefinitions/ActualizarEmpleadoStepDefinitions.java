package co.com.lulobank.certificacion.stepdefinitions;

import co.com.lulobank.certificacion.tasks.ConsumirApiMetodoPut;
import co.com.lulobank.certificacion.util.RecursosUtilidad;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ActualizarEmpleadoStepDefinitions {

    @Cuando("el realiza la peticion a la Api de {string} con id {string} para actualizar")
    public void elRealizaLaPeticionALaApiDeConIdParaActualizar(String accion, String idEmpleado) {
        theActorInTheSpotlight().attemptsTo(ConsumirApiMetodoPut.conElRecurso
                (RecursosUtilidad.ObtenerRecurso(accion, idEmpleado)));
    }

    @Entonces("la informacion del usuario quedara actualizada exitosamente {string}")
    public void laInformacionDelUsuarioQuedaraActualizadaExitosamente(String mensajeRespuesta) {
        assertThat(SerenityRest.lastResponse().path("status").toString(), equalTo("success"));
        assertThat(SerenityRest.lastResponse().path("message").toString(), equalTo(mensajeRespuesta));
    }

}
