package co.edu.ue.appkelly.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.edu.ue.appkelly.R;
import co.edu.ue.appkelly.model.Registration;
import co.edu.ue.appkelly.model.Registration;

public class RegistrationAdapter extends RecyclerView.Adapter<RegistrationAdapter.ViewHolder> {

    private List<Registration> Registration;
    private Context context;

    public RegistrationAdapter(List<Registration> Registration, Context context) {
        this.Registration = Registration;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_registros,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvReg_Date.setText(Registration.get(position).getReg_date());
        holder.tvVeh_Plate.setText(Registration.get(position).getVeh_plate());
        holder.tvUse_Name.setText(Registration.get(position).getUse_name());
        holder.tvTyre_Type.setText(Registration.get(position).getTyre_type());
    }

    @Override
    public int getItemCount() {
        return Registration.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvReg_Date;
        private TextView tvVeh_Plate;
        private TextView tvUse_Name;
        private TextView tvTyre_Type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReg_Date = itemView.findViewById(R.id.tvReg_Date);
            tvVeh_Plate = itemView.findViewById(R.id.tvVeh_Plate);
            tvUse_Name = itemView.findViewById(R.id.tvUseName);
            tvTyre_Type = itemView.findViewById(R.id.tvTyre_Type);
        }
    }
}
