package co.edu.ue.appkelly;

import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import co.edu.ue.appkelly.Adapter.RegistrationAdapter;
import co.edu.ue.appkelly.api.ServiciRegistration;
import co.edu.ue.appkelly.api.ServiciRegistration;
import co.edu.ue.appkelly.model.Registration;
import co.edu.ue.appkelly.model.ResponseRegistration;
import co.edu.ue.appkelly.model.ResponseRegistration;
import co.edu.ue.appkelly.remote.ClienteRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Mis_Registration extends AppCompatActivity {

    private Retrofit retrofit;
    private List<Registration> RegistrationList;
    private RecyclerView recyclerView;
    private RegistrationAdapter RegistrationAdapter;
    private ResponseRegistration responseRegistration;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_registration);
        recyclerView = findViewById(R.id.rvRegistration);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        showRegistration();
    }

    public void showRegistration(){
        retrofit = ClienteRetrofit.getClient(BASE_URL);
        ServiciRegistration serviciRegistration = retrofit.create(ServiciRegistration.class);
        Call<ResponseRegistration> call = serviciRegistration.registration();
        call.enqueue(new Callback<ResponseRegistration>() {
            @Override
            public void onResponse(Call<ResponseRegistration> call, Response<ResponseRegistration> response) {
                if(response.isSuccessful()){
                    responseRegistration = response.body();
                    RegistrationList = responseRegistration.getRegistration();
                    RegistrationAdapter = new RegistrationAdapter(RegistrationList,getApplicationContext());
                    recyclerView.setAdapter(RegistrationAdapter);
                }
            
            }
            @Override
            public void onFailure(Call<ResponseRegistration> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error de Peticion" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}