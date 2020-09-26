package com.example.doctorpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_login_screen extends AppCompatActivity {
    private Button button;
    private  Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_screen);
        login= (Button) findViewById(R.id.idBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivty();
            }
        });

        button = (Button) findViewById(R.id.codebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivty2();
            }
        });
    }

    private void openActivty() {
        Intent intent = new Intent(Main_login_screen.this, Main3Activity.class );
        startActivity(intent);

    }

    private void openActivty2() {
        Intent intent = new Intent(Main_login_screen.this, Main5Activity.class );
        startActivity(intent);
    }

}
