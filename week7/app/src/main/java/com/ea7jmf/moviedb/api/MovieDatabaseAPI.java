package com.ea7jmf.moviedb.api;

import com.ea7jmf.moviedb.models.MovieListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jesusft on 3/3/18.
 */

public interface MovieDatabaseAPI {

    @GET("movie/now_playing")
    Call<MovieListResponse> nowPlaying(@Query("api_key") String apiKey);

}
