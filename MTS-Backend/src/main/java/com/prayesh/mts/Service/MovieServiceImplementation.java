package com.prayesh.mts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prayesh.mts.Repository.MovieRepository;
import com.prayesh.mts.Response.MovieResponse;
import com.prayesh.mts.entity.Movie;

@Service
public class MovieServiceImplementation implements MovieService{
    
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAllThatAreShowingNow();
    }

    @Override
    public Movie movieByName(String movieName) {
        return movieRepository.findMovieByName(movieName);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> movieByCast(String castName) {
        return movieRepository.getMovieByCast(castName);
    }

    @Override
    public List<Movie> findByMovieLanguage(String language) {
        return movieRepository.getMovieByLanguage(language);
    }

    @Override
    public MovieResponse getMovieDetails(String movieId) {
        return movieRepository.fetchCompleteMovieDetails(movieId);
    }

    
}
