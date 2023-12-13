package co.edu.ue.appkelly;

import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import co.edu.ue.appkelly.api.ServiciRegistration;
import co.edu.ue.appkelly.model.Registration;
import co.edu.ue.appkelly.model.ResponseRegistration;
import co.edu.ue.appkelly.remote.ClienteRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Principal_Cela extends AppCompatActivity {

    private Retrofit retrofit;
    private Button btnIngreso;
    private Button btnSalida;
    private ImageView imgQr;
    private TextView datos;
    private Button btnCerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_cela);
        btnIngreso = findViewById(R.id.btnIngreso);
        btnSalida = findViewById(R.id.btnSalida);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        imgQr = findViewById(R.id.qrCode);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(btnIngreso.getText().toString(), BarcodeFormat.QR_CODE, 500, 500);
                    imgQr.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(btnSalida.getText().toString(), BarcodeFormat.QR_CODE, 500, 500);
                    imgQr.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
