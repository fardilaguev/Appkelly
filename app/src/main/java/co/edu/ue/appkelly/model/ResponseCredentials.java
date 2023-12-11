package co.edu.ue.appkelly.model;

import java.util.ArrayList;

public class ResponseCredentials {
    private ArrayList<Credentials> credentials;
    private String mensaje;

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }

    private String rol_id;

    public ResponseCredentials() {}

    public ArrayList<Credentials> getCredentials() {
        return credentials;
    }

    public void setCredentials(ArrayList<Credentials> credentials) {
        this.credentials = credentials;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
