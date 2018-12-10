package com.example.miran.appseguridadehigiene.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.entityTO.CatSancionTO;

import java.util.List;

public class SpinnerAdapterSancion extends BaseAdapter {

    List<CatSancionTO> sancion;
    LayoutInflater inflater;
    public SpinnerAdapterSancion(List<CatSancionTO> sancion, Activity context) {
    this.sancion = sancion;
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sancion.size();
    }

    @Override
    public CatSancionTO  getItem(int position) {
        return this.sancion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == convertView){
            view = inflater.inflate(R.layout.spinner_sancion,null);
            TextView name = view.findViewById(R.id.tv_nombresSancion);
            name.setText(sancion.get(position).getDescSancion());
        }
        return view;
    }
}
