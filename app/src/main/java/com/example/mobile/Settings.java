package com.example.mobile;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class Settings extends AppCompatActivity {

    Button btnswitch;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnswitch = findViewById(R.id.button_switch);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            btnswitch.setText("Switch to Light");

    }
    public void changeYourMotherLanguage(View v){
        Intent intent = new Intent(Settings.this, ChooseLang.class);
        startActivity(intent);
        finish();

    }
    public void logOut(View v){
        Intent intent = new Intent(Settings.this, LogReg.class);
        startActivity(intent);
        finish();

    }

    public void changeTheme(View v){

        btnswitch = findViewById(R.id.button_switch);
        String s = String.valueOf(btnswitch.getText());
        if (s.contains("Dark")) {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        } else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        }


    }
    public void choosephoto(View v){
        setContentView(R.layout.choose_photo);
    }
    public void back_to_settings(View v){
        setContentView(R.layout.activity_settings);
    }
    public void goHome(View v){
        Intent intent = new Intent(Settings.this, Home.class);
        startActivity(intent);
        finish();
    }


}