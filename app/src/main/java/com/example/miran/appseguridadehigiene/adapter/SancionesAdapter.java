package com.example.miran.appseguridadehigiene.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.entityTO.ReporteSancionTO;

import java.util.List;

public class CapacitacionesAdapter extends  RecyclerView.Adapter<CapacitacionesAdapter.MyViewHolder> {


    List<ReporteSancionTO> capacitaciones;
    Context context;
    public CapacitacionesAdapter(List<ReporteSancionTO> capacitaciones, Context context){
        this.capacitaciones = capacitaciones;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_capacitaciones, parent, false);
        return new CapacitacionesAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.fecha.setText(capacitaciones.get(position).getFecha().toString());
      holder.supervisor.setText(capacitaciones.get(position).getSupervisor());
      holder.sancionAplica.setText(capacitaciones.get(position).getSancionAplica());
      holder.numeroSancion.setText(capacitaciones.get(position).getNumeroSancion());
      ArrayAdapter adapter = new ArrayAdapter(context,android.R.layout.simple_list_item_1,capacitaciones.get(position).getFaltasCometidas());
      holder.faltasCometidas.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return capacitaciones.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fecha;
        TextView numeroSancion;
        TextView sancionAplica;
        ListView faltasCometidas;
        TextView supervisor;

        // each data item is just a string in this case
        public MyViewHolder(View item) {
            super(item);
            fecha = item.findViewById(R.id.id_fecha);
            numeroSancion = item.findViewById(R.id.id_Numero_sancion);
            sancionAplica = item.findViewById(R.id.id_sancion_aplicada);
            supervisor = item.findViewById(R.id.id_supervisor);
            faltasCometidas = item.findViewById(R.id.lisFaltasCometidas);
        }
    }

}
