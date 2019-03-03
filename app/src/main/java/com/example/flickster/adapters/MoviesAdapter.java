package com.example.flickster.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.flickster.DetailActivity;
import com.example.flickster.R;
import com.example.flickster.models.Movie;

import org.parceler.Parcels;

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
        private TextView   metaData;
        private RelativeLayout container;

       public ViewHolder(View itemView){
           super(itemView);
            this.title          =   itemView.findViewById(R.id.title);
            this.tvOverview     =   itemView.findViewById(R.id.tvOverview);
            this.ivPoster       =   itemView.findViewById(R.id.ivPoster);
            this.container      =   itemView.findViewById(R.id.rvLayout);
            this.metaData       =   itemView.findViewById(R.id.metaData1);
       }

       @SuppressLint("CheckResult")
       void bind(final Movie movie) {
           String movieURL = movie.getPosterPath();
           metaData.setText(movie.getMetaDataText());
           title.setText(movie.getTitle());
           tvOverview.setText(movie.getOverView());
           if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
               movieURL = movie.getBackDropPath();
               Log.d("bckdrp", movieURL);
           }

           int radius = 30; // corner radius, higher value = more rounded
           Glide.with(context)
                   .load(movieURL)
                   .apply(new RequestOptions()
                           .transforms(new CenterCrop(), new RoundedCorners(radius)))
                   .into(ivPoster);

           container.setOnClickListener(v -> {
                       Intent i = new Intent(context, DetailActivity.class);
                       i.putExtra("movie", Parcels.wrap(movie));
                       context.startActivity(i);
                   });
       }
    } // View Holder Class

} // Adapter Class
