package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;


public class MainActivity extends AppCompatActivity {
    int time = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        new CountDownTimer(time, time) {

            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                setContentView(R.layout.layout2);
                new CountDownTimer(time, time) {

                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        setContentView(R.layout.layout3);
                        new CountDownTimer(time, time) {

                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                setContentView(R.layout.layout4);
                                new CountDownTimer(time, time) {

                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                        setContentView(R.layout.layout5);
                                        new CountDownTimer(time, time) {

                                            public void onTick(long millisUntilFinished) {
                                            }

                                            @Override
                                            public void onFinish() {
                                                setContentView(R.layout.layout6);
                                                new CountDownTimer(time, time) {

                                                    public void onTick(long millisUntilFinished) {
                                                    }

                                                    @Override
                                                    public void onFinish() {
                                                        setContentView(R.layout.layout7);
                                                    }

                                                }.start();
                                            }

                                        }.start();
                                    }

                                }.start();
                            }

                        }.start();
                    }

                }.start();
            }

        }.start();
    }
}