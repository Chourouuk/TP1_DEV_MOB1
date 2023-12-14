package com.example.tp1_dev_mob1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp1_dev_mob1.R;

public class ConsultationActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultation);

        TextView resultTextView = (TextView) findViewById(R.id.res);

        // Retrieve the data from the Intent
        Intent intent = getIntent();

        Button btn = (Button) findViewById(R.id.back);

        if (intent != null) {
            String result = ((Intent) intent).getStringExtra("result");

            resultTextView.setText(result);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {goBack();}
        });



    }
    public void goBack() {
        Intent intent1 = new Intent();
        if(resultTextView.getText() != null && !resultTextView.getText().toString().isEmpty()) {
            setResult(RESULT_OK, intent1);
        } else {
            setResult(RESULT_CANCELED, intent1);
        }
        finish();
    }
}

