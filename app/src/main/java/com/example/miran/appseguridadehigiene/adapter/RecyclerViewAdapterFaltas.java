package com.example.miran.appseguridadehigiene.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.miran.appseguridadehigiene.entityTO.CatTipoFaltasTO;

import java.util.List;

public class SpinnerAdapterFaltas extends BaseAdapter {

    List<CatTipoFaltasTO> faltas ;
    LayoutInflater inflater;
    public SpinnerAdapterFaltas(List<CatTipoFaltasTO> faltas , Context context) {
    this.faltas = faltas;
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return faltas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (null == convertView){
            view = inflater.inflate();
        }

        return null;
    }
}
