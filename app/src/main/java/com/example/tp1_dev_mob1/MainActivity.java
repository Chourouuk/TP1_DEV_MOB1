package com.example.tp1_dev_mob1;


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

public class MainActivity extends AppCompatActivity {
    private TextView resultat;
    private Button btn;
    private SeekBar skbr;
    private TextView age;
    private RadioGroup RdGrp;
    private Boolean Jeuner;
    private EditText valM;



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

        RdGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = findViewById(checkedId);
                String selectedValue = selectedRadioButton.getText().toString();
                if (selectedValue.equals("Oui")) {
                    Jeuner = true;
                } else {
                    Jeuner = false;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean VerifAge = false , VerifValeur = false;


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
                    float valM1 = Float.valueOf(valM.getText().toString());


                    if (Jeuner) {
                        if (age >= 13 && (valM1 >= 5.0 && valM1 <= 7.2)) {
                            resultat.setText("niveau de glycémie est normale 1");
                        } else if ((age >= 6 && age <= 12) && (valM1 >= 5.0 && valM1 <= 10.0)) {
                            resultat.setText("niveau de glycémie est normale 2");
                        } else if (age < 6 && (valM1 >= 5.5 && valM1 <= 10.0)) {
                            resultat.setText("niveau de glycémie est normale 3");
                        } else {
                            if (valM1 < 5.0) {
                                resultat.setText("niveau de glycémie est trop bas");
                            } else {
                                resultat.setText("niveau de glycémie est trop elevée");
                            }
                        }
                    } else {
                        if (age >= 13 && valM1 < 10.5) {
                            resultat.setText("niveau de glycemie est normale");
                        } else {
                            resultat.setText("niveau de glycémie est trop elevée");
                        }
                    }
                }
            }

        });
    }
    public void init(){
        resultat = (TextView) findViewById(R.id.res);
        btn = (Button) findViewById(R.id.btnConsulter);
        skbr = (SeekBar) findViewById(R.id.sbAge);
        age = (TextView) findViewById(R.id.Age);
        RdGrp = (RadioGroup) findViewById(R.id.rbtGrp);
        valM = (EditText) findViewById(R.id.vm);
    }
}