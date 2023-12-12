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
import co.edu.ue.appkelly.model.Registros;

public class RegistrosAdapter extends RecyclerView.Adapter<RegistrosAdapter.ViewHolder> {

    private List<Registros> registros;
    private Context context;

    public RegistrosAdapter(List<Registros> registros, Context context) {
        this.registros = registros;
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
        holder.tvReg_Date.setText(registros.get(position).getReg_date());
        holder.tvVeh_Plate.setText(registros.get(position).getVeh_plate());
        holder.tvUse_Name.setText(registros.get(position).getUse_name());
        holder.tvTyre_Type.setText(registros.get(position).getTyre_type());
    }

    @Override
    public int getItemCount() {
        return registros.size();
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
