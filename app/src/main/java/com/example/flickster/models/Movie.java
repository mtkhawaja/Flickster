package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel

// Sample Request: https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed

public class Movie {

    protected  int         votes;
    protected  Double      rating;
    protected  int         movieID;
    protected  boolean     isAdult;
    protected  String      language;
    protected  String      releaseDate;
    protected  String      title;
    protected  String      overView;
    protected  String      backDropPath;
    protected  String      posterPath;
    protected  String      metaDataText;


    //Empty Constructor Required By Parceler Library.
    public  Movie (){}

    public Movie (JSONObject jsonObject) throws JSONException {
        this.posterPath   =  jsonObject.getString ("poster_path"      );
        this.title        =  jsonObject.getString ("title"            );
        this.overView     =  jsonObject.getString ("overview"         );
        this.backDropPath =  jsonObject.getString ("backdrop_path"    );
        this.rating       =  jsonObject.getDouble ("vote_average"     );
        this.movieID      =  jsonObject.getInt    ("id"               );
        this.votes        =  jsonObject.getInt    ("vote_count"       );
        this.isAdult      =  jsonObject.getBoolean("adult"            );
        this.language     =  jsonObject.getString ("original_language");
        this.releaseDate  =  jsonObject.getString ("release_date"     );
        this.releaseDate  =  releaseDate.substring(5,7) + "/" +
                             releaseDate.substring(8,10) + "/" + releaseDate.substring(0,4);
        String ratedR;
        if(isAdult())
            ratedR = "Rated R ";
        else
            ratedR = "";

        metaDataText =   ratedR + " Release Date: " + releaseDate + " Original Language:- " + language;

    } // constructor

    /********************************** Getters **************************************/

    public double getRating() {
        return rating;
    }

    public int getMovieID(){
        return  movieID;
    }
    public static List <Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List <Movie> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++ ){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public String getBackDropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backDropPath);
    }

    public int getVotes() {
        return votes;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public String getLanguage() {
        return language;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    public String getMetaDataText() {
        return metaDataText;
    }
} //class
