package com.example.miran.appseguridadehigiene.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.entityTO.CapacitacionTO;

import java.util.List;

public class CapacitacionAdapter extends  RecyclerView.Adapter<CapacitacionAdapter.MyViewHolder>{


    List<CapacitacionTO> capacitaciones;
    Context context;
    public CapacitacionAdapter(List<CapacitacionTO> capacitaciones, Context context){
        this.capacitaciones = capacitaciones;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_capacitaciones, parent, false);
        return new CapacitacionAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.matricula.setText(String.valueOf(capacitaciones.get(position).getMatricula()));
        holder.nombre.setText(capacitaciones.get(position).getNombre());
        ArrayAdapter adapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,capacitaciones.get(position).getCapacitacionesEmpleado());
        holder.nombreCapacitaciones.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return capacitaciones.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView matricula;
        TextView nombre;
        ListView nombreCapacitaciones;

        // each data item is just a string in this case
        public MyViewHolder(View item) {
            super(item);
            nombre = item.findViewById(R.id.id_Nombre_empleado_Capasitacion);
            matricula = item.findViewById(R.id.id_matricula_Capasitacion);
            nombreCapacitaciones = item.findViewById(R.id.listCapacitaciones);
        }
    }
}
