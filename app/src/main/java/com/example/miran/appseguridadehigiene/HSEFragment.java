package com.example.miran.appseguridadehigiene;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class HSEFragment extends Fragment {

private Button hsefragment;

    public HSEFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hse, container, false);
        hsefragment = view.findViewById(R.id.bt_ScanCod);
        hsefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new ScanFragment())
                        .addToBackStack(null).commit();
            }
        });
            return (view);
    }


        @Override
        public void onResume() {
            super.onResume();
            getActivity().setTitle("SCAN");
        }


    }
