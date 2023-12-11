package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.Loger;
import co.edu.ue.appkelly.model.ResponseCredentials;
import co.edu.ue.appkelly.model.ResponseRegistros;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiciRegistration {
    @POST("results/registros")
    public Call<ResponseRegistros> registros();

}