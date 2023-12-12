package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.ResponseVehicle;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiciVehicle {
    @GET("vehicles")
    public Call<ResponseVehicle> vehicle();

}