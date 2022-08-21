package co.com.lulobank.certificacion.runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/consultar_empleados.feature"
        , glue = "co.com.lulobank.certificacion.stepdefinitions"
        , snippets = CucumberOptions.SnippetType.CAMELCASE)
public class ConsultaEmpleados {
}
