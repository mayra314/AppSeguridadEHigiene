package com.example.miran.appseguridadehigiene.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.SancionActivity;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ResponseUserTO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PerfilEmpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PerfilEmpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilEmpFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    public static final String USER_ADMIN = "userAdmin";
    private EditText nombre;
    private  EditText matricula;
    private EditText puesto;
    private EmpleadoTO empleado;
    private ResponseUserTO user;
    private FloatingActionButton registro;
    private OnFragmentInteractionListener mListener;
    private ImageButton capacitacion;
    private ImageButton sancion;
    public PerfilEmpFragment() {
        // Required empty public constructor
    }

    public static PerfilEmpFragment newInstance(EmpleadoTO param1, ResponseUserTO param2) {
        PerfilEmpFragment fragment = new PerfilEmpFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        args.putSerializable(USER_ADMIN,param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            empleado = (EmpleadoTO) getArguments().getSerializable(ARG_PARAM1);
            user =(ResponseUserTO) getArguments().getSerializable(USER_ADMIN);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_emp, container, false);
        nombre = view.findViewById(R.id.et_nombre_perfil);
        matricula = view.findViewById(R.id.et_matricula_perfil);
        registro = view.findViewById(R.id.bt_Registro);
        puesto =  view.findViewById(R.id.et_puesto_perfil);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SancionActivity.class);
                intent.putExtra(USER_ADMIN,user);
                intent.putExtra(ARG_PARAM1,empleado);
                startActivity(intent);
            }
        });

        capacitacion = view.findViewById(R.id.btnCapacitaciones);
        capacitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(android.R.id.content, CapacitacionFragment.newInstance(empleado)).addToBackStack(null).commit();

            }
        });


        sancion = view.findViewById(R.id.btnSanciones);
        sancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(android.R.id.content, SansionescionesFragment.newInstance(empleado)).addToBackStack(null).commit();

            }
        });


        puesto.setText(empleado.getPuesto());
        nombre.setText(empleado.getNombre());
        matricula.setText(new StringBuilder().append(String.valueOf(empleado.getPkEmpleado())).append(String.valueOf(empleado.getFkEmpresa())).append(String.valueOf(empleado.getFkTipoUsuario())).toString());
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Perfil del Empleado");
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
