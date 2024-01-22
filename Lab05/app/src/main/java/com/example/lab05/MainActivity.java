package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int onCreate = 0;
    int onStart = 0;
    int onResume = 0;
    int onPause = 0;
    int onStop = 0;
    int onRestart = 0;
    int onDestroy = 0;
    TextView startDisplay;
    TextView resumeDisplay;
    TextView pauseDisplay;
    TextView stopDisplay;
    TextView restartDisplay;
    TextView destroyDisplay;
    TextView createDisplay;
    TextView lstartDisplay;
    TextView lresumeDisplay;
    TextView lpauseDisplay;
    TextView lstopDisplay;
    TextView lrestartDisplay;
    TextView ldestroyDisplay;
    TextView lcreateDisplay;
    Button runData;
    Button lifetimeData;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startDisplay = findViewById(R.id.start);
        resumeDisplay = findViewById(R.id.resume);
        pauseDisplay = findViewById(R.id.pause);
        stopDisplay = findViewById(R.id.stop);
        restartDisplay = findViewById(R.id.restart);
        destroyDisplay = findViewById(R.id.destroy);
        createDisplay = findViewById(R.id.create);
        lstartDisplay = findViewById(R.id.lstart);
        lresumeDisplay = findViewById(R.id.lresume);
        lpauseDisplay = findViewById(R.id.lpause);
        lstopDisplay = findViewById(R.id.lstop);
        lrestartDisplay = findViewById(R.id.lrestart);
        ldestroyDisplay = findViewById(R.id.ldestroy);
        lcreateDisplay = findViewById(R.id.lcreate);
        runData = findViewById(R.id.button1);
        lifetimeData = findViewById(R.id.button2);
        sharedPreferences = getSharedPreferences("lab5", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        onCreate++;
        updateData();
        editor.putString(lcreateDisplay.getTag().toString(),getString(R.string.create, 1+Integer.parseInt(sharedPreferences.getString(lcreateDisplay.getTag().toString(),getString(R.string.create, 100)).replaceAll("[^0-9]", "")))).apply();
        lcreateDisplay.setText(sharedPreferences.getString(lcreateDisplay.getTag().toString(),getString(R.string.create, 100)));
        lstartDisplay.setText(sharedPreferences.getString(lstartDisplay.getTag().toString(),getString(R.string.start, 100)));
        lrestartDisplay.setText(sharedPreferences.getString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 100)));
        lresumeDisplay.setText(sharedPreferences.getString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 100)));
        lstopDisplay.setText(sharedPreferences.getString(lstopDisplay.getTag().toString(),getString(R.string.stop, 100)));
        ldestroyDisplay.setText(sharedPreferences.getString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 100)));
        lpauseDisplay.setText(sharedPreferences.getString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 100)));
    }
    public void updateData() {
        startDisplay.setText(getString(R.string.start, onStart));
        resumeDisplay.setText(getString(R.string.resume, onResume));
        pauseDisplay.setText(getString(R.string.pause, onPause));
        stopDisplay.setText(getString(R.string.stop, onStop));
        restartDisplay.setText(getString(R.string.restart, onRestart));
        destroyDisplay.setText(getString(R.string.destroy, onDestroy));
        createDisplay.setText(getString(R.string.create, onCreate));
    }
    public void updateLifeData() {
        editor.putString(lstartDisplay.getTag().toString(),getString(R.string.start, 0)).apply();
        lstartDisplay.setText(sharedPreferences.getString(lstartDisplay.getTag().toString(),getString(R.string.start, 0)));
        editor.putString(lcreateDisplay.getTag().toString(),getString(R.string.create, 0)).apply();
        lcreateDisplay.setText(sharedPreferences.getString(lcreateDisplay.getTag().toString(),getString(R.string.create, 0)));
        editor.putString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 0)).apply();
        lrestartDisplay.setText(sharedPreferences.getString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 0)));
        editor.putString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 0)).apply();
        lresumeDisplay.setText(sharedPreferences.getString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 0)));
        editor.putString(lstopDisplay.getTag().toString(),getString(R.string.stop, 0)).apply();
        lstopDisplay.setText(sharedPreferences.getString(lstopDisplay.getTag().toString(),getString(R.string.stop, 0)));
        editor.putString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 0)).apply();
        ldestroyDisplay.setText(sharedPreferences.getString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 0)));
        editor.putString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 0)).apply();
        lpauseDisplay.setText(sharedPreferences.getString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 0)));
    }
    public void clearRunData(View v) {
        onCreate = 0;
        onStart = 0;
        onResume = 0;
        onPause = 0;
        onStop = 0;
        onRestart = 0;
        onDestroy = 0;
        updateData();
    }
    public void clearLifetimeData(View v) {
        editor.clear().apply();
        updateLifeData();
    }
    public void onStart() {
        super.onStart();
        onStart++;
        updateData();
        editor.putString(lstartDisplay.getTag().toString(),getString(R.string.start, 1+Integer.parseInt(sharedPreferences.getString(lstartDisplay.getTag().toString(),getString(R.string.start, 100)).replaceAll("[^0-9]", "")))).apply();
        lstartDisplay.setText(sharedPreferences.getString(lstartDisplay.getTag().toString(),getString(R.string.start, 100)));
    }
    public void onResume() {
        super.onResume();
        onResume++;
        updateData();
        editor.putString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 1+Integer.parseInt(sharedPreferences.getString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 100)).replaceAll("[^0-9]", "")))).apply();
        lresumeDisplay.setText(sharedPreferences.getString(lresumeDisplay.getTag().toString(),getString(R.string.resume, 100)));
    }
    public void onPause() {
        super.onPause();
        onPause++;
        updateData();
        editor.putString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 1+Integer.parseInt(sharedPreferences.getString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 100)).replaceAll("[^0-9]", "")))).apply();
        lpauseDisplay.setText(sharedPreferences.getString(lpauseDisplay.getTag().toString(),getString(R.string.pause, 100)));
    }
    public void onStop() {
        super.onStop();
        onStop++;
        updateData();
        editor.putString(lstopDisplay.getTag().toString(),getString(R.string.stop, 1+Integer.parseInt(sharedPreferences.getString(lstopDisplay.getTag().toString(),getString(R.string.stop, 100)).replaceAll("[^0-9]", "")))).apply();
        lstopDisplay.setText(sharedPreferences.getString(lstopDisplay.getTag().toString(),getString(R.string.stop, 100)));
    }
    public void onRestart() {
        super.onRestart();
        onRestart++;
        updateData();
        editor.putString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 1+Integer.parseInt(sharedPreferences.getString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 100)).replaceAll("[^0-9]", "")))).apply();
        lrestartDisplay.setText(sharedPreferences.getString(lrestartDisplay.getTag().toString(),getString(R.string.restart, 100)));
    }
    public void onDestroy() {
        super.onDestroy();
        onDestroy++;
        updateData();
        editor.putString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 1+Integer.parseInt(sharedPreferences.getString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 100)).replaceAll("[^0-9]", "")))).apply();
        ldestroyDisplay.setText(sharedPreferences.getString(ldestroyDisplay.getTag().toString(),getString(R.string.destroy, 100)));
    }
}