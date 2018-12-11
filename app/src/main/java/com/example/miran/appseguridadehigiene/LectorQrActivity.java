package com.example.miran.appseguridadehigiene;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.miran.appseguridadehigiene.entityTO.EmpleadoTO;
import com.example.miran.appseguridadehigiene.entityTO.ResponseUserTO;
import com.example.miran.appseguridadehigiene.fragment.HSEFragment;
import com.example.miran.appseguridadehigiene.httpService.EmpleadoService;
import com.example.miran.appseguridadehigiene.util.Constantes;
import com.google.zxing.Result;
import com.google.zxing.common.StringUtils;

import org.modelmapper.internal.cglib.core.Converter;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class LectorQrActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ResponseUserTO userTO;
    private ZXingScannerView mScannerView;
    public static final String USER_ADMIN = "userAdmin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permisoCamaraQr();
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
         userTO = (ResponseUserTO) getIntent().getSerializableExtra(USER_ADMIN);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        try {
            if (org.apache.commons.lang3.StringUtils.isNumeric(rawResult.getText())) {
               Intent result = new Intent(getBaseContext(), EmpleadoActivity.class);
                EmpleadoService service = new EmpleadoService();
                List<EmpleadoTO> empleado = service.execute(Long.parseLong((rawResult.getText()))).get();

                if ( empleado.size() > 0){
                    result.putExtra(Constantes.TEXT, (Serializable) empleado);
                    result.putExtra(USER_ADMIN,userTO);
                    startActivity(result);
                }else {
                    Intent intentError = new Intent(getBaseContext(), HomeActivity.class);
                    Toast.makeText(this, "Matricula no encontrada", Toast.LENGTH_LONG).show();
                    startActivity(intentError);
                }

            }else{
                Intent intentError = new Intent(getBaseContext(), HomeActivity.class);
                Toast.makeText(this, "Matricula no encontrada", Toast.LENGTH_LONG).show();
                startActivity(intentError);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
    public void permisoCamaraQr() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, Constantes.ZBAR_CAMERA_PERMISSION);
        } else {

        }
    }
}
