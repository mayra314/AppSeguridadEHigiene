package com.example.miran.appseguridadehigiene.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.adapter.SancionesAdapter;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ReporteSancionTO;
import com.example.miran.appseguridadehigiene.httpService.SancionEmpleadoService;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class SansionescionesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String ARG_PARAM1 = "param1";
    private EmpleadoTO empleado;
    public static SansionescionesFragment newInstance(EmpleadoTO param1) {
        SansionescionesFragment fragment = new SansionescionesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() !=null){
            empleado = (EmpleadoTO) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sanciones, container, false);

        ImageView   image =  view.findViewById(R.id.sinresultados);
        TextView resultados = view.findViewById(R.id.labelresuntadossan);

        SancionEmpleadoService service = new SancionEmpleadoService();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_sanciones);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        List<ReporteSancionTO> sanciones = null;
        try {
            sanciones = service.getSanciones(Long.parseLong(String.valueOf(empleado.getPkEmpleado()) + String.valueOf(empleado.getFkEmpresa()) + String.valueOf(empleado.getFkTipoUsuario())));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        if (sanciones != null && sanciones.size() > 0) {
            image.setVisibility(View.GONE);
            resultados.setVisibility(View.GONE);
        }
        mAdapter = new SancionesAdapter(sanciones,getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Sanciones");
    }
}
