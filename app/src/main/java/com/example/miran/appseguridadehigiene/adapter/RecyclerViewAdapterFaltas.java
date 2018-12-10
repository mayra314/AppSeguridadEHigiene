package com.example.miran.appseguridadehigiene.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.entityTO.CatTipoFaltasTO;

import java.util.List;

public class RecyclerViewAdapterFaltas extends  RecyclerView.Adapter<RecyclerViewAdapterFaltas.MyViewHolder>  {

    List<CatTipoFaltasTO> faltas;
    private static RecyclerViewClickListener itemListener;
    public RecyclerViewAdapterFaltas(List<CatTipoFaltasTO> faltas){
    this.faltas = faltas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_faltas, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  int position) {
     holder.descripcion.setText(faltas.get(position).DescTipoFalta);
     holder.checkBox.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

                 itemListener.recyclerViewListClicked(v,faltas.get(holder.getAdapterPosition()).PkTipoFalta,holder.checkBox.isChecked());

         }
     });
    }

    @Override
    public int getItemCount() {
        return faltas.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView descripcion ;
        CheckBox checkBox;
        // each data item is just a string in this case
        public MyViewHolder(View item) {
            super(item);
            descripcion = item.findViewById(R.id.id_description);
            checkBox = item.findViewById(R.id.id_falta);
        }
    }

    public void setOnItemClickListener(RecyclerViewClickListener clickListener) {
        RecyclerViewAdapterFaltas.itemListener =clickListener;
    }

    public interface RecyclerViewClickListener {
        void recyclerViewListClicked(View v, int idFalta, boolean checked);
    }

}