package com.example.miran.appseguridadehigiene.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.adapter.CapacitacionAdapter;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.httpService.CapacitacionEmpleadoService;

import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 */
public class CapacitacionFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String ARG_PARAM1 = "param1";
    private EmpleadoTO empleado;
    public static CapacitacionFragment newInstance(EmpleadoTO param1) {
        CapacitacionFragment fragment = new CapacitacionFragment();
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
        View view = inflater.inflate(R.layout.fragment_capacitaciones, container, false);
        CapacitacionEmpleadoService service = new CapacitacionEmpleadoService();
        mRecyclerView = view.findViewById(R.id.recycler_view_capacitaciones);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        try {
            mAdapter = new CapacitacionAdapter(service.getCapacitaciones(Long.parseLong(String.valueOf(empleado.getPkEmpleado()) + String.valueOf(empleado.getFkEmpresa())+String.valueOf(empleado.getFkTipoUsuario()))),getContext());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Capacitaciones");
    }
}