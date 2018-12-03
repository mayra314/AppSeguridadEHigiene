package com.example.miran.appseguridadehigiene.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miran.appseguridadehigiene.LectorQrActivity;
import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.HomeActivity;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.httpService.EmpleadoService;
import com.example.miran.appseguridadehigiene.util.Constantes;

/**
 * A simple {@link Fragment} subclass.
 */
public class HSEFragment extends Fragment {

    private Button hsefragment;
    private Button search;
    private EditText buscarCaja;

    public HSEFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hse, container, false);
        hsefragment = view.findViewById(R.id.bt_ScanCod);
        buscarCaja = view.findViewById(R.id.et_pass_login);
        search = view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (org.apache.commons.lang3.StringUtils.isNumeric(buscarCaja.getText().toString())) {
                        Intent result = new Intent(getContext(), HomeActivity.class);
                        EmpleadoService service = new EmpleadoService();
                        EmpleadoTO empleado = service.execute(Long.parseLong((buscarCaja.getText().toString()))).get();

                        if (empleado != null  && empleado.getPkEmpleado() > 0){
                            result.putExtra(Constantes.TEXT, empleado);
                            startActivity(result);
                        }else {
                            Toast.makeText(v.getContext(), "Matricula no encontrada", Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(v.getContext(), "Matricula no encontrada", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        hsefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), LectorQrActivity.class));
            }
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Inicio");
    }


}
