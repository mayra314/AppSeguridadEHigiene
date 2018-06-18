package com.example.miran.appseguridadehigiene;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.miran.appseguridadehigiene.util.Constantes;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class LectorQrActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{


    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permisoCamaraQr();
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        if (!rawResult.getText().equals("")) {
            Intent result = new Intent(getBaseContext(),HomeActivity.class);
            result.putExtra(Constantes.TEXT, rawResult.getText());
            startActivity(result);
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
