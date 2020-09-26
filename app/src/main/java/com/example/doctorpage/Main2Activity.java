package com.example.doctorpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button button;
    private  Button patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        patient=(Button) findViewById(R.id.pID);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivty();
            }
        });

        button = (Button) findViewById(R.id.scPT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivty2();

            }
        });

    }

    private void openActivty() {
        Intent intent = new Intent(Main2Activity.this, Main4Activity.class );
        startActivity(intent);

    }

    private void openActivty2() {
        Intent intent = new Intent(Main2Activity.this, Main6Activity.class );
        startActivity(intent);
    }
}
