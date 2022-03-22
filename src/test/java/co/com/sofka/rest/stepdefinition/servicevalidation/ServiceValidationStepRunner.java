package co.com.sofka.rest.stepdefinition.servicevalidation;

import co.com.sofka.models.Register;
import co.com.sofka.rest.setup.services.ServiceSetUp;
import co.com.sofka.rest.utils.EndPoint;
import co.com.sofka.rest.utils.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.when;
import static org.hamcrest.Matchers.*;


public class ServiceValidationStepRunner extends ServiceSetUp {
    private static final Logger LOGGER = Logger.getLogger(ServiceValidationStepRunner.class);
    private Response response;
    private RequestSpecification requestSpecification;

    @Given("que un usuario quiere registrarse con un email {string} y con una contrasena {string}")
    public void queUnUsuarioQuiereRegistrarseConUnEmailYConUnaContrasena(String email, String password) {
        try {
            Register register = new Register(JsonPath.REGISTER.getValue());
            register.setEmail(email);
            register.setPassword(password);

            generalSetUp();
            requestSpecification = given()
                    .contentType(ContentType.JSON)
                    .body(register.toString());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("el usuario realiza la peticion para solicitar el registro")
    public void elUsuarioRealizaLaPeticionParaSolicitarElRegistro() {
        try {
            response = requestSpecification.when()
                    .post(EndPoint.SUCCESSFUL_REGISTER.getValue());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("el usuario recibe una respuesta satisfactoria con un numero identificador y un token")
    public void elUsuarioRecibeUnaRespuestaSatisfactoriaConUnNumeroIdentificadorYUnToken() {
        try {
            LOGGER.info("Register Successful Section");
            response.getBody().prettyPrint();
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("id", notNullValue(),
                            "token", notNullValue()
                    );
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @When("se necesita verificar la existencia del usuario con id = {int}")
    public void seNecesitaVerificarLaExistenciaDelUsuarioConId(Integer id) {
        try {
            generalSetUp();
            response = when()
                    .get(EndPoint.SINGLE_USER.getValue() + id);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Then("se recibe una respuesta satisfactoria y se verifica que el email del usuario sea {string}")
    public void seRecibeUnaRespuestaSatisfactoriaYSeVerificaQueElEmailDelUsuarioSea(String resEmail) {
        try {
            LOGGER.info("Email verification section");
            response.getBody().prettyPrint();
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .body("data.email", is(resEmail));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }
}
