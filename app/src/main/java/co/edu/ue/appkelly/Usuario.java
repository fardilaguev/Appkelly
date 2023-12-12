package co.edu.ue.appkelly;

import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import co.edu.ue.appkelly.api.ServiciVehicle;
import co.edu.ue.appkelly.model.Vehicle;
import co.edu.ue.appkelly.model.ResponseVehicle;
import co.edu.ue.appkelly.remote.ClienteRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Usuario extends AppCompatActivity {

    private Retrofit retrofit;
    private TextView tvNam;
    private TextView tvPLac;
    private TextView tvMod;
    private Button btnRegis;
    private ResponseVehicle responseVehicle;
    public List<Vehicle> VehicleList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        tvNam = findViewById(R.id.tvNombre);
        tvMod = findViewById(R.id.tvModel);
        tvPLac = findViewById(R.id.tvPlaca);
        btnRegis = findViewById(R.id.btnRegistros);
        showUsuario();

        btnRegis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Mis_Registration.class);
            startActivity(intent);
            }
        }
);}

        public void showUsuario(){
            retrofit = ClienteRetrofit.getClient(BASE_URL);
            ServiciVehicle serviciVehicle = retrofit.create(ServiciVehicle.class);
            Call<ResponseVehicle> call = serviciVehicle.vehicle();
            call.enqueue(new Callback<ResponseVehicle>() {
                @Override
                public void onResponse(Call<ResponseVehicle> call, Response<ResponseVehicle> response) {
                    if (response.isSuccessful()) {
                        responseVehicle = response.body();
                        VehicleList = responseVehicle.getVehicle();
                        tvMod.setText(VehicleList.get(0).getMod_model());
                        tvNam.setText(VehicleList.get(0).getUse_name());
                        tvPLac.setText(VehicleList.get(0).getVeh_plate());
                    }
                }
                @Override
                public void onFailure(Call<ResponseVehicle> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Error de Peticion" + t, Toast.LENGTH_SHORT).show();
                }
            });
        }
}
