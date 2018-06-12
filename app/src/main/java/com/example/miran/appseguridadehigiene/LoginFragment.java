package com.example.miran.appseguridadehigiene;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
private Button loginFragment;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginFragment = view.findViewById(R.id.bt_loginFragment);
        loginFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content,new HSEFragment())
                        .addToBackStack(null).commit();
            }
        });
    return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Seguridad e higiene");
    }
}
