package com.example.doctorpage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctorpage.R;

public class Main11Activity extends AppCompatActivity {
    Button pres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        pres=(Button)findViewById(R.id.doc1);
        pres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpres();
            }
        });
    }
    public void openpres()
    {
        Intent intent=new Intent(this,Main12Activity.class);
        startActivity(intent);
    }

    public void bu(View view) {
    }
}
