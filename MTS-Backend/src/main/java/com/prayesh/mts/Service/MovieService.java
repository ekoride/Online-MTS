package com.prayesh.mts.Service;

import java.util.List;
import java.util.Optional;

import com.prayesh.mts.Advice.MovieNotFoundException;
import com.prayesh.mts.Response.MovieResponse;
import com.prayesh.mts.entity.Movie;

public interface MovieService {

    public List<Movie> getCurrentMovies();

    public Movie movieByName(String movieName);

    public Movie saveMovie(Movie movie);

    public List<Movie> movieByCast(String castName);

    public List<Movie> findByMovieLanguage(String language);

    public MovieResponse getMovieDetails(String movieId);

    public List<Movie> getUpcomingMovies();

    public List<Movie> getPastMovies();

    public Optional<Movie> findMovieById(long movieId);
}
