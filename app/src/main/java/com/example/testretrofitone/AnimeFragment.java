package com.example.testretrofitone;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeFragment extends Fragment {

    private int animeId;
    public final static int ACTION_OPEN_ANIME_PAGE = 1;

    TextView title, description;
    ImageView poster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anime,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        animeId = getActivity().getSharedPreferences("anime", Context.MODE_PRIVATE).getInt("animeId",1);

        initViews(view);

        getAnime();

    }

    private void getAnime() {
        Call<Anime> call = RetrofitClient.getInstance().getMyApi().getAnime(animeId);
        call.enqueue(new Callback<Anime>() {
            @Override
            public void onResponse(Call<Anime> call, Response<Anime> response) {
                title.setText(response.body().name);
                description.setText(response.body().description);

                String posterUrl = Api.BASE_URL + response.body().image.original;
                Picasso.get().load(posterUrl).into(poster);
            }

            @Override
            public void onFailure(Call<Anime> call, Throwable t) {
                Toast.makeText(getActivity(), "No success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initViews(View view){
        title = view.findViewById(R.id.anime_title);
        description = view.findViewById(R.id.description);
        poster = view.findViewById(R.id.poster_anime);
    }


    public void updateAnimePage(){
        animeId = getActivity().getSharedPreferences("anime", Context.MODE_PRIVATE).getInt("animeId",1);
        getAnime();
        Log.e("anime"," updateAnimePage - " + animeId);
    }
}
