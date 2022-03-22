package co.com.sofka.rest.setup.services;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.utils.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class ServiceSetUp {
    private static final String BASE_URL ="https://reqres.in";
    private static final String BASE_PATH ="/api";

    protected void generalSetUp(){
        setUpLog4j2();
        setBaseUri();
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(System.getProperty("user.dir") + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    private void setBaseUri(){
        RestAssured.baseURI=BASE_URL;
        RestAssured.basePath=BASE_PATH;
    }
}
