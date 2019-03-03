package com.example.flickster;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flickster.models.Movie;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;

public class DetailActivity extends YouTubeBaseActivity {
    /********************************** Instance Variables **************************************/

    private YouTubePlayerView   YouTubePlayer;
    private static final String YOUTUBE_API_KEY     = "AIzaSyD6SKEJUkJofJX2HmxYNk23PQ_5CTitznA";
    private static final String TRAILERS_API_KEY    = "https://api.themoviedb.org/3/movie/%d/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    private  Movie               movie;
   //Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView            title;
        RatingBar           rating;
        TextView            overview;
        TextView            metaData;

        movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));
      //View Holder References
        title                   = findViewById(R.id.detailMovieTitle    );
        overview                = findViewById(R.id.detailMovieOverview );
        rating                  = findViewById(R.id.ratingBar           );
        metaData                = findViewById(R.id.metaData            );
        YouTubePlayer           = findViewById(R.id.player              );

        // View Holder Data Assignment

        title.setText(movie.getTitle());
        overview.setText(movie.getOverView());
        rating.setRating((float) movie.getRating());
        metaData.setText(movie.getMetaDataText());

        // JSON Handling

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(String.format(TRAILERS_API_KEY,movie.getMovieID()), new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                   JSONArray result  = response.getJSONArray("results");
                   if (result.length() == 0)
                       return;
                   JSONObject movieTrailer  = result.getJSONObject(0);
                   final String youtubeKey = movieTrailer.getString("key");
                   initializeYoutube(youtubeKey);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

        });

    } // On-Create Method

    private void initializeYoutube(String youtubeKey) {
        YouTubePlayer.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(com.google.android.youtube.player.YouTubePlayer.Provider provider, com.google.android.youtube.player.YouTubePlayer youTubePlayer, boolean b) {
                if(movie.getRating() <= 5)
                    youTubePlayer.cueVideo(youtubeKey);
                else {
                    youTubePlayer.loadVideo(youtubeKey);
                }
            }

            @Override
            public void onInitializationFailure(com.google.android.youtube.player.YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("MovieTrailerActivity", "Error initializing YouTube player");
            }
        });
    } // initializeYoutube Method

} //class
