package co.edu.ue.appkelly;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Principal_Cela extends AppCompatActivity {

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