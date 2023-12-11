package co.edu.ue.appkelly;

import static java.security.AccessController.getContext;
import static co.edu.ue.appkelly.api.ValuesApi.BASE_URL;
import static co.edu.ue.appkelly.remote.ClienteRetrofit.retrofit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import co.edu.ue.appkelly.remote.ClienteRetrofit;

public class Mis_Registros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_registros);
    }
}