package co.com.lulobank.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/crear_empleado.feature"
        , glue = "co.com.lulobank.certificacion.stepdefinitions"
        , snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CrearEmpleado {
}
