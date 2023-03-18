package com.prayesh.mts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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










    @GetMapping("/getPastMovies")
    public ResponseEntity<List<Movie>> getPastMovies(){
        return ResponseEntity.ok(movieService.getPastMovies());
    }


    @GetMapping("/getUpcomingMovies")
    public ResponseEntity<List<Movie>> getUpcomingMovies(){
        return ResponseEntity.ok(movieService.getUpcomingMovies());
    }


    @GetMapping("/getAllMovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getCurrentMovies()); // What if no movies are returned, Error?
    }
    
    @PostMapping("/addNewMovie")
    public ResponseEntity<Movie> postMovie(@RequestBody @Valid Movie movie){
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }
}

// @GetMapping("/getMovieByCast/{name}")
    // public List<Movie> getMovieByCast(@PathVariable("name") String castName){
    //     return movieService.movieByCast(castName);
    // }