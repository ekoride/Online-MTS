package com.prayesh.mts.Service;

import java.util.List;

import com.prayesh.mts.Response.MovieResponse;
import com.prayesh.mts.entity.Movie;

public interface MovieService {

    public List<Movie> getAllMovies();

    public Movie movieByName(String movieName);

    public Movie saveMovie(Movie movie);

    public List<Movie> movieByCast(String castName);

    public List<Movie> findByMovieLanguage(String language);

    public MovieResponse getMovieDetails(String movieId);
    
}
