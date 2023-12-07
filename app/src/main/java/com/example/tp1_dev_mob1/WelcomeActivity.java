package com.example.tp1_dev_mob1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


public class WelcomeActivity extends AppCompatActivity {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        resultat();
    }

    public void resultat() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an intent to start the MainActivity
                Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);

                // Start the MainActivity
                startActivity(intent);
                finish();
            }
        },2000);

    }

}