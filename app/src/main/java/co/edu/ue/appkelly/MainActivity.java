package co.edu.ue.appkelly;

import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.ue.appkelly.api.ServiceLogin;
import co.edu.ue.appkelly.model.Credentials;
import co.edu.ue.appkelly.model.Loger;
import co.edu.ue.appkelly.model.ResponseCredentials;
import co.edu.ue.appkelly.remote.ClienteRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity{

    private Retrofit retrofit;
    private EditText user;
    private EditText pass;
    private Button ingreso;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkInit();
        ingreso.setOnClickListener(this::processLogin);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }

    private void processLogin(View view) {
        if (!validEmail(user.getText().toString()) && pass.getText().length()<=3){
            alertView("Error en los datos mal escritos");
        }else{
            Loger loger = new Loger();
            loger.setUse_email(user.getText().toString());
            loger.setUse_pass(pass.getText().toString());
            retrofit = ClienteRetrofit.getClient(BASE_URL);
            ServiceLogin serviceLogin = retrofit.create(ServiceLogin.class);
            Call<ResponseCredentials> call = serviceLogin.accessLogin(loger);
            call.enqueue(new Callback<ResponseCredentials>() {
                @Override
                public void onResponse(Call<ResponseCredentials> call, Response<ResponseCredentials> response) {
                    if(response.isSuccessful()){
                        ResponseCredentials body = response.body();
                        String msg = body.getMensaje();
                        ArrayList<Credentials> credentials = body.getCredentials();
                        Toast.makeText(MainActivity.this,"Ingresando...", Toast.LENGTH_SHORT).show();
                        if (msg.equals("OK")){
                            goTo(body.getRol_id());
                        }else {
                            alertView("Credenciales incorrectas");
                        }
                    }else{
                        alertView("Error de credenciales");
                    }
                }

                @Override
                public void onFailure(Call<ResponseCredentials> call, Throwable t) {
                    Log.i("response",t.getMessage());
                    alertView(""+t.getMessage());
                }
            });
        }
    }

    private void goTo(String rolId){
        try {
            if (Integer.parseInt(rolId) == 2){
                Intent intent = new Intent(this, Principal_Estu.class);
                startActivity(intent);
                finish();
            }else{
                Intent intent = new Intent(this, Principal_Cela.class);
                startActivity(intent);
                finish();
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static boolean isNullOrEmpty(Object obj){
        if(obj==null)return true;
        if(obj instanceof String) return ((String)obj).trim().equals("") || ((String)obj).equalsIgnoreCase("NULL");
        if(obj instanceof Integer) return ((Integer)obj)==0;
        if(obj instanceof Long) return ((Long)obj).equals(new Long(0));
        if(obj instanceof Double) return ((Double)obj).equals(0.0);
        if(obj instanceof Collection) return (((Collection)obj).isEmpty());
        return false;
    }

    public boolean validEmail(String data){
        Pattern pattern =
                Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~\\-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher mather = pattern.matcher(data);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.");
        }
        return false;
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);        }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void alertView(String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("login");
        builder.setMessage(mensaje);
        builder.setPositiveButton("ACEPTAR", null);
        builder.create();
        builder.show();
    }
    private void linkInit() {
        this.user = findViewById(R.id.etCorreo);
        this.pass = findViewById(R.id.etContra);
        this.ingreso = findViewById(R.id.btnIngresar);
        this.registrar = findViewById(R.id.btnRegistrar);
    }

}
