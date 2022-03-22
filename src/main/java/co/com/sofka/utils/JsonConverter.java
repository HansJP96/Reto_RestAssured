package co.com.sofka.utils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.log4j.Logger;

import java.io.FileReader;

public class JsonConverter {

    private static final Logger LOGGER = Logger.getLogger(JsonConverter.class);
    protected JsonReader json;
    protected Gson gson = new Gson();

    public JsonConverter(String rutaArchivo) {
        try {
            this.json= new JsonReader(new FileReader( rutaArchivo));
        } catch (Exception e) {
            LOGGER.warn("Error convirtiendo archivo json");
        }
    }

}