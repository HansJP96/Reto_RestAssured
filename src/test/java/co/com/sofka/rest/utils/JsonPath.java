package co.com.sofka.rest.utils;

public enum JsonPath {
    REGISTER("src/test/resources/files/RegisterSuccessful.json");

    private final String value;

    JsonPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
