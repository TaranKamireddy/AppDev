package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.content.SharedPreferences;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity{
    Button red_btn,green_btn,blue_btn,yellow_btn, start_btn;
    TextView[] views;
    SeekBar seekBar;
    ConstraintLayout layout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String[] correct, user;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekbar);
        start_btn = findViewById(R.id.start_btn);
        red_btn = findViewById(R.id.red_btn);
        green_btn = findViewById(R.id.green_btn);
        blue_btn = findViewById(R.id.blue_btn);
        yellow_btn = findViewById(R.id.yellow_btn);
        views = new TextView[]{red_btn,green_btn,blue_btn,yellow_btn};
        for (TextView x: views) {x.setText("0");}
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        layout = findViewById(R.id.activity_main_layout);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int prev;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                for (TextView x : views) {x.setTextSize(progress + 20);}
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                prev = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar snackbar = Snackbar.make(layout,
                        "Font Size Changed To " + seekBar.getProgress() + "sp",
                        Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(Color.BLUE);
                View snackBarView = snackbar.getView();
                TextView textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();
            }

        });
        layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editor.clear().apply();
                setValues();
                return false;
            }
        });
        setValues();
    }

    private void setValues() {
        for (TextView x:views) {
            x.setText(sharedPreferences.getString(x.getTag().toString(),"0"));
        }
        seekBar.setProgress(10);
    }

    public void click(View v) {
        TextView textView = (TextView) v;
        textView.setText("" + (1+Integer.parseInt((String) textView.getText())));
        editor.putString(textView.getTag().toString(),textView.getText().toString()).apply();
        if (index != -1) {
            user[index] = textView.getTag().toString();
            if (!user[index].equals(correct[index])) {
                Snackbar snackbar = Snackbar.make(layout,
                        "YOU FAIL",
                        Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(Color.BLUE);
                View snackBarView = snackbar.getView();
                TextView view = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                view.setTextColor(Color.RED);
                snackbar.show();
                index = -1;
            } else if (++index >= correct.length) {
                Snackbar snackbar = Snackbar.make(layout,
                        "YOU PASS",
                        Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(Color.BLUE);
                View snackBarView = snackbar.getView();
                TextView view = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
                view.setTextColor(Color.GREEN);
                snackbar.show();
                index = -1;
            }
        }
        else {
            Snackbar snackbar = Snackbar.make(layout,
                    "PLEASE RESTART",
                    Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.BLUE);
            View snackBarView = snackbar.getView();
            TextView view = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
            view.setTextColor(Color.CYAN);
            snackbar.show();
        }
    }

    public void start(View v) {
        String[] colors = {"red", "green", "blue", "yellow"};
        int factor = 9;
        correct = new String[seekBar.getProgress() - factor];
        user = new String[seekBar.getProgress() - factor];
        index = 0;
        for (int i=0; i<correct.length; i++){
            int x = 0 + (int)(Math.random() * ((3) + 1));
            correct[i] = colors[x];
        }
        String txt = "";
        for (int i=0; i< correct.length; i++){
            txt += correct[i] + " ";
        }
        Snackbar snackbar = Snackbar.make(layout,
                txt,
                Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.BLUE);
        View snackBarView = snackbar.getView();
        TextView textView = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setValues();
    }

}