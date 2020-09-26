package com.example.doctorpage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class Main6Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
    private static  final int REQUEST_CAMERA = 1;
    private  ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView= new ZXingScannerView(this);

        setContentView(scannerView);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        { if (checkPermission())
        {
            Toast.makeText(Main6Activity.this,"Permission is granted", Toast.LENGTH_LONG).show();


        }
        else {


            requestPermissions();
        }
        }


    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }
    public void onRequestPermissonsResults( int requestCode, String permission[],int grantResults[])
    {
        switch (requestCode)
        {
            case REQUEST_CAMERA :
                if(grantResults.length>0)
                {
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccepted)
                    {
                        Toast.makeText(Main6Activity.this, " Permission Granted", Toast.LENGTH_LONG).show() ;
                    }
                    else
                    {
                        Toast.makeText(Main6Activity.this, " Permission Denied", Toast.LENGTH_LONG).show() ;
                        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M )
                        {
                            if(shouldShowRequestPermissionRationale(CAMERA))
                            {
                                displayAlertMessage("You need to Allow Access for both Permission ",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                requestPermissions(new String[]{CAMERA}, REQUEST_CAMERA);

                                            }
                                        });
                                return;
                            }
                        }
                    }

                }
                break;

        }
    }
    @Override
    public void onResume()
    {
        super.onResume();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            if ( checkPermission())
            {
                if(scannerView==null)
                {
                    scannerView= new ZXingScannerView(this);
                    setContentView(scannerView);
                }
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            }
            else{
                requestPermissions();
            }
        }

    }
    @Override
    public void  onDestroy(){
        super.onDestroy();
        scannerView.stopCamera();
    }


    public void  displayAlertMessage(String message, DialogInterface.OnClickListener listener)
    {
        new AlertDialog.Builder(Main6Activity.this)
                .setMessage( message)
                .setPositiveButton("OK",listener)
                .setNegativeButton("CANCEL", null)
                .create()
                .show();


    }

    private boolean checkPermission()
    {
        return(ContextCompat.checkSelfPermission(Main6Activity.this, CAMERA)== PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void handleResult(Result result) {
        final String scanResult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                scannerView.resumeCameraPreview(Main6Activity.this);
            }
        });
        builder.setNeutralButton("Visit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(scanResult));
                startActivity(intent);

            }
        });
        builder.setMessage(scanResult);
        AlertDialog alert = builder.create();
        alert.show();


    }
}
