package co.edu.ue.appkelly.model;

public class Loger {
    private String use_email;
    private String use_pass;

    public String getUse_email() {
        return use_email;
    }

    public void setUse_email(String use_email) {
        this.use_email = use_email;
    }

    public String getUse_pass() {
        return use_pass;
    }

    public void setUse_pass(String use_pass) {
        this.use_pass = use_pass;
    }

    @Override
    public String toString() {
        return "Loger{" +
                "use_pass='" + use_pass + '\'' +
                ", use_email='" + use_email + '\'' +
                '}';
    }
}
