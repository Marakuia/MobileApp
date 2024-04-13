package com.example.mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    public EditText answerGuess;
    public Button fly;
    public Button gardener;
    public Button flower;
    public Button dog;
    public String wordPractAnsw;
    public Button checkWordPr;
    public Button checkEnterSpeech;
    public ImageButton btnSpeach;
    public EditText speech_res;
    private static final int Print_Words = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void goSettings(View v){
        Intent intent = new Intent(Home.this, Settings.class);
        startActivity(intent);
        finish();
    }
    public void guess(View v){
        setContentView(R.layout.guessanimal);
    }
    @SuppressLint("MissingInflatedId")
    public void checkAnswer(View v){
        answerGuess = findViewById(R.id.answer);
        String ans = String.valueOf(answerGuess.getText());
        ans = ans.toLowerCase();
        if (ans.equals("racoon")) {
            setContentView(R.layout.animaltrue);
        } else {
            setContentView(R.layout.animalfalse);
        }

    }
    public void tryAgain(View v){
        setContentView(R.layout.guessanimal);
    }

    public void goHomeNow(View v){
        setContentView(R.layout.activity_home);
    }
    public void wordPractice(View v){
        setContentView(R.layout.wordpractice);
    }
    public void multiplayer(View v){
        Toast.makeText(getApplicationContext(),"Multiplayer is not available now. It will be soon.", Toast.LENGTH_SHORT).show();
    }
    public void chooseAnswerWordPractice(View v){
        fly = findViewById(R.id.button_fly);
        gardener = findViewById(R.id.button_gardener);
        flower = findViewById(R.id.button_flower);
        dog = findViewById(R.id.button_dog);

        if (v.getId()== R.id.button_fly) {

            fly.setBackgroundColor(getResources().getColor(R.color.blue));
            gardener.setBackgroundColor(getResources().getColor(R.color.grey));
            flower.setBackgroundColor(getResources().getColor(R.color.grey));
            dog.setBackgroundColor(getResources().getColor(R.color.grey));
            wordPractAnsw = String.valueOf(fly.getText());
        }
        if (v.getId()== R.id.button_gardener) {

            fly.setBackgroundColor(getResources().getColor(R.color.grey));
            gardener.setBackgroundColor(getResources().getColor(R.color.blue));
            flower.setBackgroundColor(getResources().getColor(R.color.grey));
            dog.setBackgroundColor(getResources().getColor(R.color.grey));
            wordPractAnsw = String.valueOf(gardener.getText());
        }
        if (v.getId()== R.id.button_flower) {
            fly.setBackgroundColor(getResources().getColor(R.color.grey));
            gardener.setBackgroundColor(getResources().getColor(R.color.grey));
            flower.setBackgroundColor(getResources().getColor(R.color.blue));
            dog.setBackgroundColor(getResources().getColor(R.color.grey));
            wordPractAnsw = String.valueOf(flower.getText());
        }
        if (v.getId()== R.id.button_dog) {
            fly.setBackgroundColor(getResources().getColor(R.color.grey));
            gardener.setBackgroundColor(getResources().getColor(R.color.grey));
            flower.setBackgroundColor(getResources().getColor(R.color.grey));
            dog.setBackgroundColor(getResources().getColor(R.color.blue));
            wordPractAnsw = String.valueOf(dog.getText());
        }

    }
    @SuppressLint("SetTextI18n")
    public void checkAnswerWordPractice(View v){
        checkWordPr = findViewById(R.id.button_checkwordpr);


        if (String.valueOf(checkWordPr.getText()).contains("Check")) {
            fly = findViewById(R.id.button_fly);
            gardener = findViewById(R.id.button_gardener);
            flower = findViewById(R.id.button_flower);
            dog = findViewById(R.id.button_dog);

            gardener.setBackgroundColor(getResources().getColor(R.color.green));
            if (wordPractAnsw.equals(String.valueOf(fly.getText()))) {
                fly.setBackgroundColor(getResources().getColor(R.color.naranja));
            }
            if (wordPractAnsw.equals(String.valueOf(flower.getText()))) {
                flower.setBackgroundColor(getResources().getColor(R.color.naranja));
            }
            if (wordPractAnsw.equals(String.valueOf(dog.getText()))) {
                dog.setBackgroundColor(getResources().getColor(R.color.naranja));
            }
            checkWordPr.setText("Next");
        }
        else {
            setContentView(R.layout.activity_home);
        }


    }
    public void audioPractice(View v){
        setContentView(R.layout.audition);
    }

    public void Listening(View v){
        setContentView(R.layout.listening);
    }


    @SuppressLint("SetTextI18n")
    public void checkSpeach(View v){
        speech_res = findViewById(R.id.speachanswer);
        if ((speech_res.getText() != null) && (speech_res.getText().length() != 0)) {

            Resources resources = getResources();
            int blackColor = resources.getColor(R.color.black, null);
            speech_res.setTextColor(blackColor);
            speech_res.setText("");
            checkEnterSpeech.setText("Check");

        }
        btnSpeach = findViewById(R.id.button_speech);
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, Print_Words);




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        speech_res = findViewById(R.id.speachanswer);

        //Проверяем успешность получения обратного ответа:
        if (requestCode == Print_Words && resultCode == RESULT_OK) {
            //Как результат получаем строковый массив слов, похожих на произнесенное:
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            //и отображаем их в элементе TextView:
            assert result != null;
            speech_res.setText(result.get(0));

        }
        super.onActivityResult(requestCode, resultCode, data);

    }
    @SuppressLint("SetTextI18n")
    public void checkEnterSpeech(View v){
        speech_res = findViewById(R.id.speachanswer);
        checkEnterSpeech = findViewById(R.id.button_checkenterspeech);
        if (String.valueOf(checkEnterSpeech.getText()).contains("Check")) {
            Resources resources = getResources();
            int greenColor = resources.getColor(R.color.green,  null);
            int radColor = resources.getColor(R.color.roja,  null);

            if ((speech_res.getText() != null) && (speech_res.getText().length() != 0)) {
                String ans = String.valueOf(speech_res.getText());
                ans = ans.toLowerCase();

                if (ans.equals("cucumber")) {

                    speech_res.setTextColor(greenColor);

                    checkEnterSpeech.setText("Yay! Go next!");
                } else {
                    speech_res.setTextColor(radColor);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Say the word.", Toast.LENGTH_SHORT).show();
            }
        } else {
            setContentView(R.layout.activity_home);
        }

    }


}