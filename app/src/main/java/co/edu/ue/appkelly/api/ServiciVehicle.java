package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.ResponseVehicle;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiciPerfil {
    @GET("vehicles")
    public Call<ResponseVehicle> perfil();

}