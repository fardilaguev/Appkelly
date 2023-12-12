package co.edu.ue.appkelly;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import co.edu.ue.appkelly.model.User;
import retrofit2.Retrofit;

public class Registro extends AppCompatActivity {
    public Retrofit retrofit;
    public EditText etCorreo2;
    public EditText etContra2;
    public EditText etName;
    public EditText etPlaca;
    public EditText etModelo;
    public Button btnRegister;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Spinner spinner = findViewById(R.id.spVehiculo);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this::register);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = adapterView.getItemAtPosition(position).toString();
                if (selectedItem.equals("Moto")) {
                    mostrarDatosMoto();
                } else if (selectedItem.equals("Bicicleta")) {
                    mostrarDatosBicicleta();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Moto");
        arrayList.add("Bicicleta");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

    }

    private void register(View view) {
        User user = new User();
        user.setUse_email(etCorreo2.getText().toString());
        user.setUse_password(etContra2.getText().toString());
        user.setUse_name(etName.getText().toString());

    }

    private void mostrarDatosBicicleta() {

    }

    private void mostrarDatosMoto() {
    }
}