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

public class Signup extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize SharedPreferences instance
        sharedPreferences = getSharedPreferences("SignUp", MODE_PRIVATE);


        Button btn =(Button) findViewById(R.id.signInButton);
        EditText user =(EditText) findViewById(R.id.user);
        EditText email =(EditText) findViewById(R.id.email);
        EditText pwd =(EditText) findViewById(R.id.pwd);
        EditText rpwd =(EditText) findViewById(R.id.rpwd);
        Button btn1 =(Button) findViewById(R.id.signUpButton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.getText().toString().isEmpty() && !email.getText().toString().isEmpty()){
                    if(!pwd.getText().toString().isEmpty()){
                        if(!rpwd.getText().toString().isEmpty() && pwd.getText().toString().equals(rpwd.getText().toString())){
                            saveData(user.getText().toString(),pwd.getText().toString());
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
    private void saveData(String user,String pwd) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user" , user);
        editor.putString("password" ,pwd);
        editor.apply();
    }
}