package com.example.tp1_dev_mob1.view;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp1_dev_mob1.R;

import com.example.tp1_dev_mob1.controller.Controller;
import com.example.tp1_dev_mob1.ConsultationActivity;

public class MainActivity extends AppCompatActivity {
    private String resultat;
    private Button btn;
    private SeekBar skbr;
    private TextView age;
    private RadioButton rbtOui;
    private Boolean Jeuner;
    private EditText valM;
    private final int REQUEST_CODE=1;
 ;

    private Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();



        skbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged" + progress);
                age.setText("Votre Age : " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "START_CHANGE_SEEKBAR", Toast.LENGTH_SHORT).show();
            }

            @Override()
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean VerifAge = false, VerifValeur = false;

                if (skbr.getProgress() != 0)
                    VerifAge = true;
                else
                    Toast.makeText(MainActivity.this, "veuillez vérifiez votre age", Toast.LENGTH_SHORT).show();


                if (!valM.getText().toString().isEmpty())
                    VerifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "veuillez vérifiez votre mesurée ", Toast.LENGTH_SHORT).show();

                if (VerifAge && VerifValeur) {

                    int age = skbr.getProgress();
                    double valM1 = Double.valueOf(valM.getText().toString());
                    Jeuner=rbtOui.isChecked();

                    controller.createPatient(age,valM1,Jeuner);

                    resultat=controller.getConsultation();

                    resultat();
                }
            }
        });
    }


    public void init() {
        btn = (Button) findViewById(R.id.btnConsulter);
        skbr = (SeekBar) findViewById(R.id.sbAge);
        age = (TextView) findViewById(R.id.Age);
        rbtOui = (RadioButton) findViewById(R.id.rbtOui);
        valM = (EditText) findViewById(R.id.vm);

    }

    public void resultat() {
        // Créer une intention pour démarrer l'activité Consultation
        Intent intent = new Intent(MainActivity.this, ConsultationActivity.class);

        // Transmettre la valeur de 'res' à Consultation
        intent.putExtra("result", resultat);

        // Démarrer l'activité Consultation
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}