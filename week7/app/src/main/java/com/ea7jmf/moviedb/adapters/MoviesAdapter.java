package com.ea7jmf.moviedb.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ea7jmf.moviedb.R;
import com.ea7jmf.moviedb.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jesusft on 3/3/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView poster;
        public TextView title;
        public TextView description;

        public ViewHolder(View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.ivPoster);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
        }
    }

    private List<Movie> mMovies;
    private Context mContext;

    public MoviesAdapter(List<Movie> mMovies, Context mContext) {
        this.mMovies = mMovies;
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.movie_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        if (mContext.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso
                    .with(mContext)
                    .load(movie.getPosterURL())
                    .into(holder.poster);
        } else {
            Picasso
                    .with(mContext)
                    .load(movie.getBackgdropURL())
                    .into(holder.poster);
        }

        holder.title.setText(movie.getTitle());
        holder.description.setText(movie.getOverview());

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
