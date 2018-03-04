package com.ea7jmf.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ea7jmf.moviedb.adapters.MoviesAdapter;
import com.ea7jmf.moviedb.api.MovieDatabaseAPI;
import com.ea7jmf.moviedb.models.Movie;
import com.ea7jmf.moviedb.models.MovieListResponse;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MovieDatabaseAPI moviesService;

    private MoviesAdapter adapter;
    private RecyclerView rvMovies;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.moviesService = ((MovieDBApplication)getApplication()).getMoviesService();

        movies = new LinkedList<>();

        setupView();

        moviesService.nowPlaying("a07e22bc18f5cb106bfe4cc1f83ad8ed").enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                movies.addAll(response.body().getResults());
                adapter.notifyItemRangeInserted(0, response.body().getResults().size());
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error retrieving movies", Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

    private void setupView() {
        rvMovies = findViewById(R.id.rvMovies);

        adapter = new MoviesAdapter(movies, this);
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

}
