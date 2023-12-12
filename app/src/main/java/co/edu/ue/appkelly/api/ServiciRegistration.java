package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.ResponseRegistration;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiciRegistration {
    @GET("registrations")
    public Call<ResponseRegistration> registration();

}