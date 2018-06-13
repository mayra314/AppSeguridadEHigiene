package com.example.miran.appseguridadehigiene;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements  ZXingScannerView.ResultHandler {
    private ZXingScannerView escanerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }

    public void EscanerQR(View view){
        escanerView = new ZXingScannerView(this );
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();

    }


    @Override
    protected void onPause(){
        super.onPause();
        escanerView.startCamera();
    }


    @Override
    public void handleResult(com.google.zxing.Result result) {
        AlertDialog.Builder
                builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del escaner");
        builder.setMessage(result.getText());
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        escanerView.resumeCameraPreview(this);
    }
}
