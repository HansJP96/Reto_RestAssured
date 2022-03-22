package co.com.sofka.rest.runners.servicevalidation;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/servicevalidation.feature"},
        glue = {"co.com.sofka.rest.stepdefinition.servicevalidation"}
)
public class ServiceValidationTest {
}
