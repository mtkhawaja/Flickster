# Flickster
Submitted by: **Muneeb Khawaja**

**Flickster** is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flickster Part 2

### User Stories

#### REQUIRED

* [x] Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
* [x] Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

* [x] Trailers for popular movies are played automatically when the movie is selected.
  * [x] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  * [x] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
* [x] Add a rounded corners for the images using the Glide transformations.  
- [ ] Add a play icon overlay to popular movies to indicate that the movie can be played.
- [ ] Apply the popular ButterKnife annotation library to reduce view boilerplate.


#### ADDITIONAL 

* [x] Created a metaData instance variable in the Movie class. This variable contains information about the release date of the movie,
	  the original language of the movie and also information about whether or not the movie is rated R. (If the movie is not rated 	   R, then this segment is ignored). This variable is used to populate TextView fields on both the activity_detail and 			   item_movie layouts.
* [x] Implemented a landscape layout for the detail_activity. 
* [x] Changed the theme of detail_activity to black and white (background and text respectively). 
* [x] Adding padding between rows for aesthetic purposes. 


### App Walkthough GIF

<img src="Flickster App Walkthrough 2.gif" title = 'Video Walkthrough' width='' alt='Video Walkthrough' ><br>
GIF created with [ShareX](https://getsharex.com/).


## Flickster Part 1

### User Stories

#### REQUIRED 

* [x]  User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database	 		API.

#### BONUS
* [x] Views should be responsive for both landscape/portrait mode.
* [x] In portrait mode, the poster image, title, and movie overview is shown.
* [x] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie 		       overview to the right of it.
* [x] Improved the user interface by experimenting with styling and coloring.
* [ ] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [ ] For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster 		       image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files 	  	for popular movies and less popular ones.

#### ADDITIONAL 
* [x] Implemented Application Logo. 
* [x] Implemented auto-size font for Movie Titles. 

### App Walkthough GIF

<img src="Flickster App Walkthrough 1.gif" title = 'Video Walkthrough' width='' alt='Video Walkthrough' ><br>
GIF created with [ShareX](https://getsharex.com/).

### Notes
I targeted API lvl 28, a fact which caused its fair share of headaches. For example, I had to configure the andriod manifest to parse
clear text HTTPS requests in order to work with the Movie Database API. Furhtermore, it took me a while before I was comfortable with using Andriod Studio's debugging tools.  


### Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http)- Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide)- Image loading and caching library for Androids
- [Glide Transformation]()-Third-Person Party used to perform transformations on images.

### Other Libraries
- [The Movie Database API](http://docs.themoviedb.apiary.io/#) 
- [YouTube Data API 3](https://developers.google.com/youtube/v3/getting-started)

## License

    Copyright [2019] [Muneeb T. Khawaja]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


