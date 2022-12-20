package com.bnjke.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultQuiz extends AppCompatActivity {

    TextView quiztext, aans, bans, cans, dans;
    List<Questions> questions;
    int currentQuestions = 0;
    int correct = 0, wrong =0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiztext = findViewById(R.id.quizText);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);

        loadAllQuestions();
        Collections.shuffle(questions);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(currentQuestions).getAns1().equals(questions.get(currentQuestions).getCorrect())){
                    correct++;
                    aans.setBackgroundResource(R.color.white);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    aans.setBackgroundResource(R.color.white);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }


                if(currentQuestions < questions.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            aans.setBackgroundResource(R.color.white);
                            aans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else{
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(currentQuestions).getAns2().equals(questions.get(currentQuestions).getCorrect())){
                    correct++;
                    bans.setBackgroundResource(R.color.white);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    bans.setBackgroundResource(R.color.white);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }


                if(currentQuestions < questions.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            bans.setBackgroundResource(R.color.white);
                            bans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else{
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(currentQuestions).getAns3().equals(questions.get(currentQuestions).getCorrect())){
                    correct++;
                    cans.setBackgroundResource(R.color.white);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    cans.setBackgroundResource(R.color.white);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }


                if(currentQuestions < questions.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            cans.setBackgroundResource(R.color.white);
                            cans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else{
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(currentQuestions).getAns4().equals(questions.get(currentQuestions).getCorrect())){
                    correct++;
                    dans.setBackgroundResource(R.color.white);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    dans.setBackgroundResource(R.color.white);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }


                if(currentQuestions < questions.size()-1){
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            dans.setBackgroundResource(R.color.white);
                            dans.setTextColor(getResources().getColor(R.color.text_secondary_color));
                        }
                    },500);
                }else{
                    Intent intent = new Intent(DifficultQuiz.this, ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(questions.get(currentQuestions).getQuestions());
        aans.setText(questions.get(currentQuestions).getAns1());
        bans.setText(questions.get(currentQuestions).getAns2());
        cans.setText(questions.get(currentQuestions).getAns3());
        dans.setText(questions.get(currentQuestions).getAns4());
    }

    private void loadAllQuestions() {
        questions = new ArrayList<>();
        String jsonquiz = loadJsonFromAsset("difficultquiz.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questionsall = jsonObject.getJSONArray("difficultquiz");
            for (int i=0; i<questionsall.length();i++){
                JSONObject question = questionsall.getJSONObject(i);

                String questionsString = question.getString("question");
                String ans1String = question.getString("ans1");
                String ans2String = question.getString("ans2");
                String ans3String = question.getString("ans3");
                String ans4String = question.getString("ans4");
                String correctString = question.getString("correct");

                questions.add(new Questions(questionsString, ans1String, ans2String, ans3String, ans4String, correctString));

            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s){
        String json="";
        try{
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
    @Override
    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(DifficultQuiz.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Are u want to exit the quiz?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(DifficultQuiz.this,MainActivity.class));
            }
        });
        materialAlertDialogBuilder.show();
    }
}