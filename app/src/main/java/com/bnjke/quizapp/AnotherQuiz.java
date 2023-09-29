package com.bnjke.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import android.widget.Button;
import android.widget.EditText;

public class AnotherQuiz extends AppCompatActivity {

    TextView quiztext, aans, bans, cans, dans;
    List<Questions> questions;
    int currentQuestions = 0;
    int correct = 0, wrong =0;
    Intent intent;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiztext = findViewById(R.id.quizText);
        aans = findViewById(R.id.aanswer);
        bans = findViewById(R.id.banswer);
        cans = findViewById(R.id.canswer);
        dans = findViewById(R.id.danswer);
        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.open();
        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(quiztext)});
        userCursor.moveToFirst();
        quiztext.setText(userCursor.getString(1));
        aans.setText(String.valueOf(userCursor.getString(2)));
        bans.setText(String.valueOf(userCursor.getString(3)));
        cans.setText(String.valueOf(userCursor.getString(4)));
        dans.setText(String.valueOf(userCursor.getString(5)));
        userCursor.close();
        Collections.shuffle(questions);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questions.get(currentQuestions).getAns1().equals(questions.get(currentQuestions).getCorrect())){
                    correct++;
                    aans.setBackgroundResource(R.color.green);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    aans.setBackgroundResource(R.color.red);
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
                    Intent intent = new Intent(AnotherQuiz.this, ResultActivity.class);
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
                    bans.setBackgroundResource(R.color.green);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    bans.setBackgroundResource(R.color.red);
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
                    Intent intent = new Intent(AnotherQuiz.this, ResultActivity.class);
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
                    cans.setBackgroundResource(R.color.green);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    cans.setBackgroundResource(R.color.red);
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
                    Intent intent = new Intent(AnotherQuiz.this, ResultActivity.class);
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
                    dans.setBackgroundResource(R.color.green);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }else{
                    wrong++;
                    dans.setBackgroundResource(R.color.red);
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
                    Intent intent = new Intent(AnotherQuiz.this, ResultActivity.class);
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

    @Override
    public void onBackPressed(){
        db.close();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(AnotherQuiz.this);
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
                startActivity(new Intent(AnotherQuiz.this,MainActivity.class));
            }
        });
        materialAlertDialogBuilder.show();
    }
}