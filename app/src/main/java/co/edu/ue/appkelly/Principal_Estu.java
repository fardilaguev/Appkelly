package co.edu.ue.appkelly;

import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import co.edu.ue.appkelly.api.ServiciRegistration;
import co.edu.ue.appkelly.model.Registration;
import co.edu.ue.appkelly.model.ResponseRegistration;
import co.edu.ue.appkelly.remote.ClienteRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Principal_Estu extends AppCompatActivity {

    private Retrofit retrofit;
    private Button btnScan;
    private TextView tvScan;
    private ImageButton ibCuen;
    private String veh_i;
    private String tyre_i;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_estu);
        btnScan = findViewById(R.id.btnScan);
        tvScan = findViewById(R.id.tvScan);
        ibCuen = findViewById(R.id.ibCuenta);
        ibCuen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Usuario.class);
                startActivity(intent);
            }
        });
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrador = new IntentIntegrator(Principal_Estu.this);
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrador.setPrompt("Lector - CDP");
                integrador.setCameraId(0);
                integrador.setBeepEnabled(true);
                integrador.setBarcodeImageEnabled(true);
                integrador.initiateScan();
                Toast.makeText(Principal_Estu.this, "mano", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String type;
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result!=null){
            if (result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show();
            }else{
                String text = result.getContents().replace(" ","");

                if (text!="Ingreso"){
                    Toast.makeText(this, ""+result.getContents().toString(), Toast.LENGTH_SHORT).show();
                    type = "2";
                }else{
                    type = "1";
                }
                Toast.makeText(this, type, Toast.LENGTH_SHORT).show();
                register(type,"1");
            }
        }
    }

    private void register(String type, String user) {

    }

    private void alertView(String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login"); // Título de la alerta
        builder.setMessage(mensaje); // Mensaje de la alerta
        builder.setPositiveButton("Aceptar", null);
        builder.create();
        builder.show();
    }
    private void goTo(String rolId) {
        try {
            Intent intent = new Intent(this, Principal_Cela.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}