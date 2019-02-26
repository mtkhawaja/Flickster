# Flickster
Submitted by: **Muneeb Khawaja**

**Flickster** is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flickster Part 1

### User Stories

#### REQUIRED 
	- [x]  User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database	 		API.

#### BONUS
	- [x] Views should be responsive for both landscape/portrait mode.
	- [x] In portrait mode, the poster image, title, and movie overview is shown.
	- [x] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie 		      overview to the right of it.
	- [ ] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-		      Library#advanced-usage) for each image during loading
	- [x] Improved the user interface by experimenting with styling and coloring.
	- [ ] For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster 		      image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files 		      for popular movies and less popular ones.

#### ADDITIONAL 
	-[x] Implemented Application Logo. 


### App Walkthough GIF

<img src="Flickster App.gif" title = 'Video Walkthrough' width='' alt='Video Walkthrough' ><br>
GIF created with [ShareX](https://getsharex.com/).
### Notes
I targeted API lvl 28, a fact which caused its fair share of headaches. For example, I had to configure the andriod manifest to parse
clear text HTTPS requests in order to work with the Movie Database API. Furhtermore, it took me a while before I was comfortable with using Andriod Studio's debugging tools.  


### Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) 			    - Image loading and caching library for Androids

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




