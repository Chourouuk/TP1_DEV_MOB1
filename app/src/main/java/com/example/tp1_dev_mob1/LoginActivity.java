package com.example.tp1_dev_mob1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tp1_dev_mob1.view.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btn =(Button) findViewById(R.id.signUpButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultat();
            }
        });


    }
    public void resultat() {
        // Créer une intention pour démarrer l'activité Consultation
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        // Démarrer l'activité Consultation
        startActivity(intent);
        finish();
    }
}