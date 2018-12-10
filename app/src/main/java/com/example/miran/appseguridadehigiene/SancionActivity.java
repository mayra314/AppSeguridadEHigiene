package com.example.miran.appseguridadehigiene;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.miran.appseguridadehigiene.adapter.SpinnerAdapterSancion;
import com.example.miran.appseguridadehigiene.entityTO.CatSancionTO;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ResponseUserTO;
import com.example.miran.appseguridadehigiene.entityTO.SancionEmpleadoTO;
import com.example.miran.appseguridadehigiene.fragment.DialogFaltasFragment;
import com.example.miran.appseguridadehigiene.httpService.SancionEmpleadoService;
import com.example.miran.appseguridadehigiene.interfaz.ComunicadorDialog;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SancionActivity extends AppCompatActivity implements ComunicadorDialog {
    private FloatingActionButton GuardarSancion;
    private Button btnFaltas;
    private Spinner spinnerSAncion;
    private Spinner spinnerNumSancion;
    private List<Long> idFaltas;
    private EditText estatus;
    private EditText fecha;
    private EditText nombre;
    private EditText matricula;
    private EditText otrasSanciones;
    private EditText observaciones;
    private ResponseUserTO user;
    private static final String ARG_PARAM1 = "param1";
    public static final String USER_ADMIN = "userAdmin";
    private EmpleadoTO empleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
          empleado = (EmpleadoTO) bundle.getSerializable(ARG_PARAM1);
          user = (ResponseUserTO) bundle.getSerializable(USER_ADMIN);
        }

        spinnerSAncion = findViewById(R.id.spinnerSancion);
        spinnerSAncion.setAdapter(cargaComboSancion());

        spinnerNumSancion = findViewById(R.id.spinnerNumSancion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.num_sanciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumSancion.setAdapter(adapter);


        btnFaltas = findViewById(R.id.btn_faltas);
        estatus =  findViewById(R.id.et_estatus);
        matricula = findViewById(R.id.et_matricula);
        nombre = findViewById(R.id.et_nombre);
        fecha = findViewById(R.id.et_fecha);
        otrasSanciones = findViewById(R.id.et_otrasSanciones);
        observaciones =  findViewById(R.id.et_observaciones);


        cargarDatos();

        btnFaltas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = DialogFaltasFragment.newInstance();
                newFragment.show(getSupportFragmentManager(), "dialog");
            }
        });

        GuardarSancion = findViewById(R.id.bt_GuardarSan);
        GuardarSancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarDatosGuardarSancion();

            }
        });
    }

    private void cargarDatosGuardarSancion() {
        SancionEmpleadoService service = new SancionEmpleadoService();
        SancionEmpleadoTO sancionEmpleadoTO = new SancionEmpleadoTO();
        sancionEmpleadoTO.setPkRegSancion(0);
        sancionEmpleadoTO.setFkEmpleado(empleado.getPkEmpleado());
        sancionEmpleadoTO.setFkEmpresa(empleado.getFkEmpresa());
        sancionEmpleadoTO.setFkTipoUsuario(empleado.getFkTipoUsuario());
        sancionEmpleadoTO.setFecha(new Date());
        sancionEmpleadoTO.setNumSancion(spinnerNumSancion.getSelectedItem().toString());
        sancionEmpleadoTO.setOtrasFaltas(otrasSanciones.getText().toString());
        sancionEmpleadoTO.setObservaciones(observaciones.getText().toString());
        sancionEmpleadoTO.setFkSancion(((CatSancionTO) spinnerSAncion.getSelectedItem()).getPkSancion());
        sancionEmpleadoTO.setFkEstatus(1);
        sancionEmpleadoTO.setFkUsuarioGral(user.getIdUser());
        sancionEmpleadoTO.setIdSancionesFaltas(idFaltas);
        try {
            Long aLong = service.saveSancion(sancionEmpleadoTO);
            if (aLong == 200){
                Toast.makeText(SancionActivity.this, "Sancion agregada exitosamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,HomeActivity.class);
                intent.putExtra("text",empleado);
                intent.putExtra(USER_ADMIN,user);
                startActivity(intent);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public SpinnerAdapter cargaComboSancion() {
        try {
            SancionEmpleadoService sanciones = new SancionEmpleadoService();
            return new SpinnerAdapterSancion(sanciones.getSanciones(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Registrar sancion");
    }

    @Override
    public void comunicarFragment(List<Long> ids) {
      idFaltas = ids;
        Toast.makeText(this, String.valueOf(ids), Toast.LENGTH_SHORT).show();
    }


    public void cargarDatos(){
        nombre.setText(empleado.getNombre());
        estatus.setText("En proceso");
        fecha.setText(new Date().toString());
        matricula.setText(new StringBuilder().append(empleado.getPkEmpleado()).append(empleado.getFkEmpresa()).append(empleado.getFkTipoUsuario()));
    }

}