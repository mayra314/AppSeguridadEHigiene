package com.example.miran.appseguridadehigiene.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.miran.appseguridadehigiene.R;


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
    private EditText nombre;
    private String mParam1;

    private OnFragmentInteractionListener mListener;

    public PerfilEmpFragment() {
        // Required empty public constructor
    }

    public static PerfilEmpFragment newInstance(String param1) {
        PerfilEmpFragment fragment = new PerfilEmpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_emp, container, false);
        nombre = view.findViewById(R.id.et_nombre_perfil);
        nombre.setText(mParam1);
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
