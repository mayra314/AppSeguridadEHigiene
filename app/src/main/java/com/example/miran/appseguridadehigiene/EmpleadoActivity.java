package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.miran.appseguridadehigiene.adapter.CapacitacionAdapter;
import com.example.miran.appseguridadehigiene.adapter.EmpleadoAdaper;
import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ResponseUserTO;
import com.example.miran.appseguridadehigiene.httpService.CapacitacionEmpleadoService;
import com.example.miran.appseguridadehigiene.util.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EmpleadoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String USER_ADMIN = "userAdmin";
    List<EmpleadoTO> empleados = new ArrayList<>();
    ResponseUserTO userTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

             userTO = (ResponseUserTO) getIntent().getSerializableExtra(USER_ADMIN);
             empleados = (List<EmpleadoTO>) getIntent().getSerializableExtra(Constantes.TEXT);

        setContentView(R.layout.activity_empleado);
        CapacitacionEmpleadoService service = new CapacitacionEmpleadoService();
        mRecyclerView = findViewById(R.id.recycler_view_empleado);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EmpleadoAdaper(empleados,this,userTO);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("Empleados encontrados");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
