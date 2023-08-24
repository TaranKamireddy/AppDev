package com.example.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    Button decrementButton;
    TextView titleDisplay;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        decrementButton = findViewById(R.id.decrement_button);
        titleDisplay = findViewById(R.id.heading);
    }
    public void increment(View view) {
        System.out.println("incrementing: "+ ++count);
        titleDisplay.setText(""+count);
    }
    public void decrement(View view) {
        System.out.println("decrementing: "+ --count);
        titleDisplay.setText(""+count);
    }
}