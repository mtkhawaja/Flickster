package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel

public class Movie {
    //Empty Constructor Required By Parceler Library.
    public  Movie (){

    }
    private String posterPath;
    private String title;
    private String overView;
    private String backDropPath;
    private Double rating;
    private int     movieID;


    public Movie (JSONObject jsonObject) throws JSONException {
        this.posterPath   =  jsonObject.getString("poster_path"   );
        this.title        =  jsonObject.getString("title"         );
        this.overView     =  jsonObject.getString("overview"      );
        this.backDropPath =  jsonObject.getString("backdrop_path" );
        this.rating       =  jsonObject.getDouble ("vote_average" );
        this.movieID      =  jsonObject.getInt    ("id"           );
    } // constructor

    public double getRating() {
        return rating;
    }

    public int getmovieID(){
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
} //class
