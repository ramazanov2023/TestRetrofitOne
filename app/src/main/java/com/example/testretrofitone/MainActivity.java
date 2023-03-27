package com.example.testretrofitone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeInterface{

    boolean authentication;
    SharedPreferences pref;
    FrameLayout frameAuth;
    ViewPager2 pagesList;
    TabLayout tabLayout;
    String[] tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameAuth = findViewById(R.id.frame_auth);

        pref = getSharedPreferences("anime", MODE_PRIVATE);

        authentication = pref.getBoolean("auth", true);

        if (authentication) {
            frameAuth.setVisibility(View.VISIBLE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.frame_auth, new AuthenticationFragment())
                    .commit();


        } else {
            loadAnimePages();
        }
    }

    @Override
    public void setAction(int action) {
        switch(action){
            case AuthenticationFragment.ACTION_CLOSE_AUTH_PAGE:
                pref.edit().putBoolean("auth", false).apply();

                loadAnimePages();

                frameAuth.setVisibility(View.GONE);
        }
    }

    private void loadAnimePages(){
        pagesList = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);
        tabTitles = getResources().getStringArray(R.array.anime_titles);



        ArrayList < Fragment > pages = new ArrayList<>();
        pages.add(0,new ListAnimeFragment());
        pages.add(1,new AnimeFragment());
        pages.add(2,new CharactersAnimeFragment());
        pages.add(3,new SimilarAnimeFragment());

        AnimePagesAdapter adapter = new AnimePagesAdapter(getSupportFragmentManager(),getLifecycle(),pages);
        pagesList.setAdapter(adapter);

//        new TabLayoutMediator(tabLayout, pagesList, true, (tab, position) -> {
//            tab.setText(tabTitles[position]);
//            Log.e("tabnull","onConfigureTab - " + tab.getText());
//        }).attach();

        new TabLayoutMediator(tabLayout, pagesList, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabTitles[position]);
            }
        }).attach();

    }
}