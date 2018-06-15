package com.example.miran.appseguridadehigiene;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.miran.appseguridadehigiene.fragment.ScanFragment;

public class LectorQrActivity extends AppCompatActivity {
    private static final int ZBAR_CAMERA_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permisoCamaraQr();
        setContentView(R.layout.activity_lector_qr);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,new ScanFragment()).commit();
    }
    public void permisoCamaraQr() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, ZBAR_CAMERA_PERMISSION);
        } else {



        }
    }
}
