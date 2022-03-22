package co.com.sofka.models;

import co.com.sofka.utils.JsonConverter;

public class Register extends JsonConverter {
    private String email;
    private String password;

    public Register(String jsonPath) {
        super(jsonPath);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        Register data = gson.fromJson(json,Register.class);
        data.setEmail(email);
        data.setPassword(password);
        return gson.toJson(data);
    }
}
