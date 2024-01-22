package com.example.lab06;

import android.graphics.Color;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class CubeOutTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setPivotX( position < 0f ? page.getWidth() : 0f );
        page.setPivotY( page.getHeight() * 0.5f );
        page.setRotationY( 90f * position );
        MainActivity.mediaPlayer.start();

//        String[] colors = {"red", "green", "blue", "yellow"};
//        int factor = 9;
//        correct = new String[seekBar.getProgress() - factor];
//        user = new String[seekBar.getProgress() - factor];
//        index = 0;
//        for (int i=0; i<correct.length; i++){
//            int x = 0 + (int)(Math.random() * ((3) + 1));
//            correct[i] = colors[x];
//        }
    }
}