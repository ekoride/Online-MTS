package com.prayesh.mts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prayesh.mts.Response.MovieResponse;
import com.prayesh.mts.Service.MovieService;
import com.prayesh.mts.entity.Movie;

import jakarta.validation.Valid;

@RestController
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies(); // What if no movies are returned, Error? 
    }

    //Change to Only available movies.
    @GetMapping("/getMovieByName/{name}")
    public Movie getMovieByName(@PathVariable("name") String movieName){
        return movieService.movieByName(movieName);
    }


    @GetMapping("/getMovieByLanguage/{language}")
    public List<Movie> getMovieByLanguage(@PathVariable("language") String language){
        return movieService.findByMovieLanguage(language);
    }



    @GetMapping("/getCompleteMovie/{movieId}")
    public MovieResponse getMovieDetails(@PathVariable(value = "movieId") String movieId){
        return movieService.getMovieDetails(movieId);
    }

    // @GetMapping("/getMovieByCast/{name}")
    // public List<Movie> getMovieByCast(@PathVariable("name") String castName){
    //     return movieService.movieByCast(castName);
    // }

    
    @PostMapping("/addNewMovie")
    public Movie postMovie(@RequestBody @Valid Movie movie){
        return movieService.saveMovie(movie);
    }
}

// @GetMapping("/getMovieByCast/{name}")
    // public List<Movie> getMovieByCast(@PathVariable("name") String castName){
    //     return movieService.movieByCast(castName);
    // }