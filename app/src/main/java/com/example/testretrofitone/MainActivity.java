package com.example.testretrofitone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeInterface{

    boolean authentication;
    SharedPreferences pref;
    FrameLayout frameAuth;
    ViewPager2 pagesList;

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
        pagesList = findViewById(R.id.pages_list);

        ArrayList<Fragment> pages = new ArrayList<>();
        pages.add(0,new ListAnimeFragment());
        pages.add(1,new AnimeFragment());
        pages.add(2,new CharactersAnimeFragment());
        pages.add(3,new SimilarAnimeFragment());

        AnimePagesAdapter adapter = new AnimePagesAdapter(getSupportFragmentManager(),getLifecycle(),pages);
        pagesList.setAdapter(adapter);

    }
}