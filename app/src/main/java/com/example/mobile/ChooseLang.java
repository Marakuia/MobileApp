package com.example.mobile;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChooseLang extends AppCompatActivity implements View.OnClickListener{
    private Button btnRus;
    private Button btnEng;
    private Button btnCh;
    private Button btnBel;
    private Button btnKaz;
    private Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.choose_language);
        btnRus = findViewById(R.id.button_lng_1);
        btnEng = findViewById(R.id.button_lng_2);
        btnCh = findViewById(R.id.button_lng_3);
        btnBel = findViewById(R.id.button_lng_4);
        btnKaz = findViewById(R.id.button_lng_5);
        btnChoose = findViewById(R.id.button_next);

        btnRus.setOnClickListener(this);
        btnEng.setOnClickListener(this);
        btnCh.setOnClickListener(this);
        btnBel.setOnClickListener(this);
        btnKaz.setOnClickListener(this);
        btnChoose.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.button_lng_1) {

            btnRus.setBackgroundColor(getResources().getColor(R.color.naranja));
            btnEng.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnCh.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnBel.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnKaz.setBackgroundColor(getResources().getColor(R.color.amarilla));
        }
        if (v.getId()== R.id.button_lng_2) {

            btnRus.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnEng.setBackgroundColor(getResources().getColor(R.color.naranja));
            btnCh.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnBel.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnKaz.setBackgroundColor(getResources().getColor(R.color.amarilla));
        }
        if (v.getId()== R.id.button_lng_3) {
            btnRus.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnEng.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnCh.setBackgroundColor(getResources().getColor(R.color.naranja));
            btnBel.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnKaz.setBackgroundColor(getResources().getColor(R.color.amarilla));
        }
        if (v.getId()== R.id.button_lng_4) {
            btnRus.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnEng.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnCh.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnBel.setBackgroundColor(getResources().getColor(R.color.naranja));
            btnKaz.setBackgroundColor(getResources().getColor(R.color.amarilla));
        }
        if (v.getId()== R.id.button_lng_5) {
            btnRus.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnEng.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnCh.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnBel.setBackgroundColor(getResources().getColor(R.color.amarilla));
            btnKaz.setBackgroundColor(getResources().getColor(R.color.naranja));
        }
        if (v.getId()== R.id.button_next) {
            Intent intent = new Intent(ChooseLang.this, Settings.class);
            startActivity(intent);
            finish();
        }
    }

}