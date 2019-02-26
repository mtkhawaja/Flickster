package com.example.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flickster.R;
import com.example.flickster.models.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context         context;
    private List <Movie>    movies;

    public MoviesAdapter(Context context, List <Movie> movies){
        this.context    = context;
        this.movies     = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie movie = movies.get(position);
        viewHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView tvOverview;
        private ImageView ivPoster;

       public ViewHolder(View itemView){
           super(itemView);
            this.title          =   itemView.findViewById(R.id.title);
            this.tvOverview     =   itemView.findViewById(R.id.tvOverview);
            this.ivPoster       =   itemView.findViewById(R.id.ivPoster);
       }

       void bind(Movie movie){
           String movieURL = movie.getPosterPath();
           title.setText(movie.getTitle());
           tvOverview.setText(movie.getOverView());
           Log.d("smile", movieURL);
           Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    } // View Holder Class

} // Adapter Class
