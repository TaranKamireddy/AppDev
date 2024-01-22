package com.example.lab06;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    ViewPager2 mvp;
    RecyclerView.Adapter mfsa;
    final int n = 5;
    static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.air);
        mvp = findViewById(R.id.container);
        mfsa = new MyFragmentStateAdapter(this);
        mvp.setAdapter(mfsa);
        mvp.setPageTransformer(new CubeOutTransformer());
    }
    public class MyFragmentStateAdapter extends FragmentStateAdapter {
        public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            int[] colors = {Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.YELLOW};
            int x = 0 + (int)(Math.random() * ((4) + 1));
            mvp.setBackgroundColor(colors[x]);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            int[] colors = {Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.YELLOW};
            int x = 0 + (int)(Math.random() * ((4) + 1));
            mvp.setBackgroundColor(colors[x]);
            return MainFragment.newInstance(mvp, position);

        }

        @Override
        public int getItemCount(){
            return n;
        }
    }
}