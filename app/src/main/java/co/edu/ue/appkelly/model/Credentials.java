package co.edu.ue.appkelly.model;

public class Credentials {
    private String use_id;
    private String use_key;
    private String use_indentifier;
    private String rol_id;

    public String getUse_indentifier() {
        return use_indentifier;
    }

    public void setUse_indentifier(String use_indentifier) {
        this.use_indentifier = use_indentifier;
    }

    public String getUse_key() {
        return use_key;
    }

    public void setUse_key(String use_key) {
        this.use_key = use_key;
    }

    public String getUse_id() {
        return use_id;
    }

    public void setUse_id(String use_id) {
        this.use_id = use_id;
    }

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }
}