package com.example.lab06;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    ViewPager2 vp2;
    int position;
    public static MainFragment newInstance(ViewPager2 mvp, int position){
        MainFragment fragment = new MainFragment();
        fragment.vp2 = mvp;
        fragment.position=position;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment,container,false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = getActivity().findViewById(R.id.tab);
        new TabLayoutMediator(tabLayout, vp2,
                (tab,position) -> tab.setText("Color: " + (position+1))
        ).attach();
        Button bruh = view.findViewById(R.id.button);
        bruh.setText("Random Color " + position);

    }
}
