package com.example.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LogReg extends AppCompatActivity {
    EditText vEmail;
    EditText vPas;
    EditText firstName;
    EditText lastName;
    EditText newEmail;
    EditText newPas;
    EditText confPas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_or_reg);
        vEmail = findViewById(R.id.emailAd);
        vPas = findViewById(R.id.passw);

    }
    public void signup(View v){
         setContentView(R.layout.signup1);
    }
    public void signupnext(View v){
        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        newEmail = findViewById(R.id.newemail);
        if((firstName.getText().length()==0) || (lastName.getText().length()==0) || (newEmail.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(),"There should be no empty fields", Toast.LENGTH_SHORT).show();
        }
         else {
             setContentView(R.layout.signup2);
         }
    }
    public void back(View v){
        setContentView(R.layout.log_or_reg);
    }
    public void back_signup(View v){
        setContentView(R.layout.signup1);
    }
    public void login(View v){

        if((vPas.getText().length()==0) || (vEmail.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(),"There should be no empty fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(LogReg.this, Settings.class);
            startActivity(intent);
            finish();
        }
    }
    public void signup_final(View v){
        newPas = findViewById(R.id.newpassw);
        confPas = findViewById(R.id.confpassw);

        if((newPas.getText().length()==0) || (confPas.getText().length()==0))
        {
            Toast.makeText(getApplicationContext(),"There should be no empty fields", Toast.LENGTH_SHORT).show();
        } else if (newPas.getText().toString().contentEquals(confPas.getText().toString())) {
            Intent intent = new Intent(LogReg.this, Settings.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(),"Password mismatch", Toast.LENGTH_SHORT).show();
        }
    }
}