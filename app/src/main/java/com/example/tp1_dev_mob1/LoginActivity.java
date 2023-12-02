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

public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Move SharedPreferences initialization here
        sharedPreferences = getSharedPreferences("SignUp", MODE_PRIVATE);

        Button btn =(Button) findViewById(R.id.signUpButton);
        EditText user =(EditText) findViewById(R.id.usernameEditText);
        EditText pwd =(EditText) findViewById(R.id.passwordEditText);
        Button btn1 =(Button) findViewById(R.id.signInButton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the value stored with the key "DEVELOPER"
                String username = sharedPreferences.getString("user", "");
                String password = sharedPreferences.getString("password", "");

                if(!user.getText().toString().isEmpty() && !pwd.getText().toString().isEmpty()){
                    if(user.getText().toString().equals(username) && pwd.getText().toString().equals(password)){
                        resultat();
                        Toast.makeText(LoginActivity.this, "Login succesffuly", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Username, Password are required !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
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

    public void login() {
        // Créer une intention pour démarrer l'activité Consultation
        Intent intent = new Intent(LoginActivity.this, Signup.class);

        // Démarrer l'activité Consultation
        startActivity(intent);
    }
}