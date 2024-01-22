package com.example.lab08;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Drawing drawing;
    static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawing = findViewById(R.id.drawing);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bouncy);

    }

    public void reverse(View v){
        drawing.dy*=-1;
        drawing.dx*=-1;
    }
    public void increase(View v){
        drawing.dy+=1;
        drawing.dx+=1;
    }
    public void decrease(View v){
        drawing.dy-=1;
        drawing.dx-=1;
    }
}