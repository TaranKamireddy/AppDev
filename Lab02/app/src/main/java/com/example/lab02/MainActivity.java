package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    Button decrementButton;
    TextView titleDisplay;
    TextView messageDisplay;
    EditText setName;
    String[] messages;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        decrementButton = findViewById(R.id.decrement_button);
        titleDisplay = findViewById(R.id.heading);
        messages = getResources().getStringArray(R.array.messages);
        messageDisplay = findViewById(R.id.message);
        messageDisplay.setText(getString(R.string.first_message,messages[0],count));
        setName = findViewById(R.id.name);
    }
    public void increment(View view) {
        System.out.println("incrementing: "+ count);
        count = ++count%messages.length;
        messageDisplay.setText(getString(R.string.first_message,messages[count],count));
    }
    public void decrement(View view) {
        System.out.println("decrementing: "+ count);
        if(--count<0)count=messages.length - 1;
        messageDisplay.setText(getString(R.string.first_message,messages[count],count));
    }
    public void name(View view) {
        titleDisplay.setText(getString(R.string.hello,setName.getText()));
    }
}