package com.example.doctorpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welcome_doc_Screen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_doc__screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    Intent homeIntent = new Intent(Welcome_doc_Screen.this, Main_login_screen.class);
                    startActivity(homeIntent);
                    finish();
                }

        }, SPLASH_TIME_OUT);
    }
}
