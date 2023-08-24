package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    Button decrementButton;
    Button startButton;
    TextView titleDisplay;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        decrementButton = findViewById(R.id.decrement_button);
        startButton = findViewById(R.id.start_button);
        titleDisplay = findViewById(R.id.heading);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(count, 1000){
                    public void onTick(long millisUntilFinished){
                        titleDisplay.setText(String.valueOf(count/1000));
                        count -= 1000;
                    }
                    public void onFinish(){
                        titleDisplay.setText("FINISH!!");
                    }
                }.start();
            }
        });
    }
    public void increment(View view) {
        count += 1000;
        System.out.println("incrementing: "+ count);
        titleDisplay.setText(""+count/1000);
    }
    public void decrement(View view) {
        count -= 1000;
        System.out.println("decrementing: "+ count);
        titleDisplay.setText(""+count/1000);
    }
}