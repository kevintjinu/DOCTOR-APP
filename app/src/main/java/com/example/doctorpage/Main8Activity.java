package com.example.doctorpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main8Activity extends AppCompatActivity {
    private Button BMI;
    private Button health;
    private Button write;
    private Button aps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        aps=(Button)findViewById(R.id.AP);
        aps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

        write=(Button)findViewById(R.id.Wrt_btn);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        health =(Button) findViewById(R.id.HS_btn);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        BMI =(Button) findViewById(R.id.bmi_btn);
        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }

    private void openActivity4() {
        Intent intent = new Intent(this, Main11Activity.class);
        startActivity(intent);
    }

    private void openActivity3() {
        Intent intent = new Intent(this, Main12Activity.class);
        startActivity(intent);
    }

    private void openActivity() {
        Intent intent = new Intent(this, Main10Activity.class);
        startActivity(intent);

    }

    private void openActivity2() {

        Intent intent = new Intent(this, bmi.class);
        startActivity(intent);

    }
}
