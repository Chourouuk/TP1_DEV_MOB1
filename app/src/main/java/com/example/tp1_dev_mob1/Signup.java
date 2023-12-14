package com.example.tp1_dev_mob1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp1_dev_mob1.view.MainActivity;
import com.example.tp1_dev_mob1.controller.LoginController;

public class Signup extends AppCompatActivity {

    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btn =(Button) findViewById(R.id.signInButton);
        EditText user =(EditText) findViewById(R.id.user);
        EditText email =(EditText) findViewById(R.id.email);
        EditText pwd =(EditText) findViewById(R.id.pwd);
        EditText rpwd =(EditText) findViewById(R.id.rpwd);
        Button btn1 =(Button) findViewById(R.id.signUpButton);

        loginController=LoginController.getInstance(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.getText().toString().isEmpty() && !email.getText().toString().isEmpty()){
                    if(!pwd.getText().toString().isEmpty()){
                        if(!rpwd.getText().toString().isEmpty() && pwd.getText().toString().equals(rpwd.getText().toString())){
                            loginController.CreateUser(user.getText().toString(),pwd.getText().toString(),Signup.this);
                            resultat();
                            Toast.makeText(Signup.this, "Created succesffuly", Toast.LENGTH_SHORT).show();
                        }else if (!pwd.getText().toString().equals(rpwd.getText().toString())) {
                            Toast.makeText(Signup.this, "Merci de verifier votre pwd", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Signup.this, "Merci d'entrer un password", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Signup.this, "Username, Email are required !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });


    }
    public void resultat() {
        // Créer une intention pour démarrer l'activité Consultation
        Intent intent = new Intent(Signup.this, MainActivity.class);

        // Démarrer l'activité Consultation
        startActivity(intent);
        finish();
    }

    public void Signup() {


        // Créer une intention pour démarrer l'activité Consultation
        Intent intent = new Intent(Signup.this, LoginActivity.class);

        // Démarrer l'activité Consultation
        startActivity(intent);
    }
}