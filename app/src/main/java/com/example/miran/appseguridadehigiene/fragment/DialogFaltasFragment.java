package com.example.miran.appseguridadehigiene.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.adapter.RecyclerViewAdapterFaltas;
import com.example.miran.appseguridadehigiene.entityTO.CatTipoFaltasTO;
import com.example.miran.appseguridadehigiene.httpService.SancionEmpleadoService;
import com.example.miran.appseguridadehigiene.interfaz.ComunicadorDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFaltasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogFaltasFragment extends DialogFragment {

    public static DialogFaltasFragment newInstance() {
        return new DialogFaltasFragment();
    }

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapterFaltas mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button cancelar;
    private Button aceptar;
    ComunicadorDialog dialog;
    private List<Long> faltasId = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_faltas, container, false);
        cargarFaltas(v);
        aceptar = v.findViewById(R.id.btn_aceptar);
        cancelar = v.findViewById(R.id.btn_cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aceptar();
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog = (ComunicadorDialog) getActivity();
    }

    private void cargarFaltas(View v) {
        try {
            SancionEmpleadoService service = new SancionEmpleadoService();
            mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_faltas);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new RecyclerViewAdapterFaltas(service.getTipoFaltas());
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new RecyclerViewAdapterFaltas.RecyclerViewClickListener() {
                @Override
                public void recyclerViewListClicked(View v, int idFalta, boolean checked) {
                    if (checked){
                        faltasId.add((long)idFalta);

                    }else {
                        if (faltasId.size() > 0){
                            faltasId.remove(removeElement(idFalta));
                        }
                    }
                }
            });
         } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int removeElement(int element){
        for (int i = 0 ; i < faltasId.size() ; i++){

            if (element == faltasId.get(i)){

                return i;
            }
        }
        return -1;
    }

    public void  cancelar(){
        this.faltasId.clear();
        getDialog().dismiss();
    }


    public void aceptar(){
        dialog.comunicarFragment(this.faltasId);
        getDialog().dismiss();
    }

}
