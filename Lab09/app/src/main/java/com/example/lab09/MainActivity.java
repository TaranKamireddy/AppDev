package com.example.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    int speed = 5;
    boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView=findViewById(R.id.drawView);
    }

    public void moveLeft(View view) {
        if (paused == false) {
            paused = true;
        }
        drawView.sprite.setdY(0);
        drawView.sprite.setdX(-speed);
    }

    public void moveRight(View view) {
        if (paused == false) {
            paused = true;
        }
        drawView.sprite.setdY(0);
        drawView.sprite.setdX(speed);
    }

    public void moveUp(View view) {
        if (paused == false) {
            paused = true;
        }
        drawView.sprite.setdX(0);
        drawView.sprite.setdY(-speed);
    }

    public void moveDown(View view) {
        if (paused == false) {
            paused = true;
        }
        drawView.sprite.setdX(0);
        drawView.sprite.setdY(speed);
    }

    public void pause(View view) {
        drawView.sprite.setdX(0);
        drawView.sprite.setdY(0);
        paused = true;
    }
}