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
import com.example.miran.appseguridadehigiene.HomeActivity;
import com.example.miran.appseguridadehigiene.R;
import com.example.miran.appseguridadehigiene.entityTO.LoginTO;
import com.example.miran.appseguridadehigiene.httpService.LoginService;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private Button loginFrag;
    private EditText txtUser;
    private EditText txtPassword;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtUser = (EditText) view.findViewById(R.id.et_username_login);
        txtPassword = (EditText) view.findViewById(R.id.et_pass_login);
        loginFrag = (Button) view.findViewById(R.id.bt_loginFragment);


        loginFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se genera una instancia de donde se encuentra el servicio httpGet

                if (txtUser.getText().toString().equals("")){
                    Toast.makeText(getContext(), "Ingresar usuario", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (txtPassword.getText().toString().equals("") ){
                    Toast.makeText(getContext(), "Ingresar Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                try {
                    LoginService login = new LoginService();
                    // mse crea un objeto de tipo loginTO
                    LoginTO loginTo = new LoginTO();
                    loginTo.setUser(txtUser.getText().toString());
                    loginTo.setPassword(txtPassword.getText().toString());
                    String name = login.execute(loginTo).get();
                    if (!name.equals("")){
                        Intent i = new Intent(getContext(), HomeActivity.class);
                        startActivity(i);
                    return;
                    }
                    Toast.makeText(getContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
             e.printStackTrace();
                }
            }
        });

        return  view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Seguridad e higiene");
    }

}