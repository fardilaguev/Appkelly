package co.edu.ue.appkelly.model;

public class User {
    public String use_name;
    public String use_email;
    public String use_password;
    public String veh_plate;
    public String mod_id;

    public String getVeh_plate() {
        return veh_plate;
    }

    public void setVeh_plate(String veh_plate) {
        this.veh_plate = veh_plate;
    }

    public String getMod_id() {
        return mod_id;
    }

    public void setMod_id(String mod_id) {
        this.mod_id = mod_id;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    public String getUse_email() {
        return use_email;
    }

    public void setUse_email(String use_email) {
        this.use_email = use_email;
    }

    public String getUse_password() {
        return use_password;
    }

    public void setUse_password(String use_password) {
        this.use_password = use_password;
    }
}
