package co.com.lulobank.certificacion.stepdefinitions;

import co.com.lulobank.certificacion.tasks.ConsumirApiMetodoGet;
import co.com.lulobank.certificacion.util.RecursosUtilidad;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;

public class ConsultaEmpleadosStepDefinitions {

    @Before
    public void configuracionInicial() {
        setTheStage(new Cast());
        theActorCalled("Andres");
    }

    @Dado("que el usuario hace un llamado a la API de dummy restapiexample")
    public void queElUsuarioHaceUnLlamadoALaAPIDeDummyRestapiexample() {
        theActorInTheSpotlight().whoCan(CallAnApi.at("http://dummy.restapiexample.com"));
    }
    @Cuando("el realiza la peticion a la Api de {string}")
    public void elRealizaLaPeticionALaApiDe(String accion) {
        theActorInTheSpotlight().attemptsTo(
                ConsumirApiMetodoGet.conElRecurso(RecursosUtilidad.ObtenerRecurso(accion,"0")));
    }
    @Entonces("el podra obtener toda la informacion de los empleados")
    public void elPodraObtenerTodaLaInformacionDeLosEmpleados() {
        assertThat(SerenityRest.lastResponse().path("status").toString(), equalTo("success"));
        assertThat(SerenityRest.lastResponse().path("data"), anything());
    }

    @Cuando("el realiza la peticion a la Api de {string} con id {string}")
    public void elRealizaLaPeticionALaApiDeConId(String accion, String idEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                ConsumirApiMetodoGet.conElRecurso(RecursosUtilidad.ObtenerRecurso(accion,idEmpleado)));
    }

    @Entonces("el podra obtener toda la informacion del empleado con id {string}")
    public void elPodraObtenerTodaLaInformacionDelEmpleadoConId(String idEmpleado) {
        assertThat(SerenityRest.lastResponse().path("status").toString(), equalTo("success"));
        assertThat(SerenityRest.lastResponse().path("data.id").toString(), equalTo(idEmpleado));
        System.out.println(SerenityRest.lastResponse().path("data.employee_name").toString());
    }

}
