package co.edu.ue.appkelly.api;

import co.edu.ue.appkelly.model.Loger;
import co.edu.ue.appkelly.model.ResponseCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ServiceLogin {
    @POST("login")
    public Call<ResponseCredentials> accessLogin(@Body Loger loger);
}



