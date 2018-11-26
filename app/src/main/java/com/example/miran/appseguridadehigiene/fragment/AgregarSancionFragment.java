package com.example.miran.appseguridadehigiene.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.RegistrarSActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //AgregarSancionFragment.//OnFragmentInteractionListener} interface
 * to handle interaction events.
 * //Use the {@link // AgregarSancionFragment //#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarSancionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of p arameters
    private Button GuardarSancion;
    private Object mListener;
    private String mParam1;

    public AgregarSancionFragment() {
        // Required empty public constructor
    }

  public static AgregarSancionFragment newInstance(String param1) {
        AgregarSancionFragment fragment = new AgregarSancionFragment();
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
        View view = inflater.inflate(R.layout.fragment_agregar_sancion, container, false);
        GuardarSancion = view.findViewById(R.id.bt_GuardarSan);

        GuardarSancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), RegSancionesragment.class));
            }
        });

        return view;
  }




    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("REGISTRAR SANCION");
    }


}
