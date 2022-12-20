package com.bnjke.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mSplashTread;
        mSplashTread = new Thread(){
            @Override public void run(){
                try{
                    synchronized (this){
                        wait(2000);
                    }

                }catch (InterruptedException ignored){
                }
                finally {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }
        };
        mSplashTread.start();
    }
}