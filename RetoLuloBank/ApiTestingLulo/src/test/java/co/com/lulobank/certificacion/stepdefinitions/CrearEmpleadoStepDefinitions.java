package co.com.lulobank.certificacion.stepdefinitions;

import co.com.lulobank.certificacion.models.Empleado;
import co.com.lulobank.certificacion.tasks.ConsumirApiCreacionEmpleados;
import co.com.lulobank.certificacion.util.ConfiguracionDataTableUtilidad;
import co.com.lulobank.certificacion.util.RecursosUtilidad;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CrearEmpleadoStepDefinitions {

    @Cuando("el realiza la peticion a la Api de {string} con la informacion")
    public void elRealizaLaPeticionALaApiDeConLaInformacion(String accion, Map<String, String> datosEmpleado) {
        theActorInTheSpotlight().attemptsTo(ConsumirApiCreacionEmpleados.conLaInformacion(
                RecursosUtilidad.ObtenerRecurso(accion, "0"),
                ConfiguracionDataTableUtilidad.retornarObjetoEmpleados(datosEmpleado)));
    }
    @Entonces("el podra visualizar una respuesta exitosa con la informacion registrada")
    public void elPodraVisualizarUnaRespuestaExitosaConLaInformacionRegistrada(Map<String, String> datosEmpleado) {
        assertThat(SerenityRest.lastResponse().path("status").toString(), equalTo("success"));
        assertThat(SerenityRest.lastResponse().path("data.name").toString(), equalTo(datosEmpleado.get("nombre")));
        assertThat(SerenityRest.lastResponse().path("data.salary").toString(), equalTo(datosEmpleado.get("salario")));
        assertThat(SerenityRest.lastResponse().path("data.age").toString(), equalTo(datosEmpleado.get("edad")));
        System.out.println(SerenityRest.lastResponse().path("data.id").toString());
    }

}
