package com.example.testretrofitone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://shikimori.one";
    @GET("/api/animes")
    Call<List<Anime>> getDynamicEndPoints(@Query("limit") int limit);
}
