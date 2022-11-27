package com.example.android_3125_exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText cad, usd;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cad = findViewById(R.id.cad);
        usd = findViewById(R.id.usd);
        calculate = findViewById(R.id.btnCal);
    }

    @SuppressLint("SetTextI18n")
    public void calculateCurrency(View view) {
        String cadText = cad.getText().toString();
        String usdText = usd.getText().toString();

        if (!cadText.isEmpty() && !usdText.isEmpty()) {
            Toast.makeText(this, "Please input only USD or CAD", Toast.LENGTH_LONG).show();
        } else if (cadText.isEmpty() && usdText.isEmpty()) {
            Toast.makeText(this, "Please input number USD or CAD", Toast.LENGTH_LONG).show();
        } else if (cadText.isEmpty()) {
            //to cad
            double usdDouble = Double.parseDouble(usdText);
            cad.setText("" + usdDouble/1.33);
        } else {
            // to usd
            double cadDouble = Double.parseDouble(cadText);
            usd.setText("" + cadDouble*1.33);
        }
    }
}