package com.ea7jmf.moviedb;

import android.app.Application;

import com.ea7jmf.moviedb.api.MovieDatabaseAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jesusft on 3/3/18.
 */

public class MovieDBApplication extends Application {

    private MovieDatabaseAPI moviesService;

    @Override
    public void onCreate() {
        super.onCreate();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        moviesService = retrofit.create(MovieDatabaseAPI.class);
    }

    public MovieDatabaseAPI getMoviesService() {
        return moviesService;
    }

}
