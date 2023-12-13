package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.Registration;
import co.edu.ue.appkelly.model.ResponseRegistration;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiciRegistration {
    @GET("registrations")
    public Call<ResponseRegistration> registration();

    @POST("registration")
    public Call<ResponseRegistration> regisDiario(Registration registration);
}