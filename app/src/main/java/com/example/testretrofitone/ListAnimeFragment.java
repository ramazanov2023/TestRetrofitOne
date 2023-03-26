package com.example.testretrofitone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAnimeFragment extends Fragment {

    RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_anime,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recycler = view.findViewById(R.id.recycler_view);

        runRetrofit();

    }

    private void runRetrofit() {
        Call<List<Anime>> call = RetrofitClient.getInstance().getMyApi().getDynamicEndPoints(20);
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                recycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                recycler.setAdapter(new AnimeListAdapter(getContext(),response.body()));
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }


}
