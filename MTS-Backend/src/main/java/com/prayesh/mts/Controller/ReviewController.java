package com.prayesh.mts.Controller;

import com.prayesh.mts.Advice.MovieNotFoundException;
import com.prayesh.mts.RequestHandlers.ReviewRequest;
import com.prayesh.mts.Service.MovieService;
import com.prayesh.mts.Service.ReviewService;
import com.prayesh.mts.entity.Movie;
import com.prayesh.mts.entity.Review;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private MovieService movieService;

    @PostMapping("/{id}/postReview")
    public ResponseEntity<Review> postReview(@RequestBody @Valid ReviewRequest reviewRequest, @PathVariable("id") long movieId) throws MovieNotFoundException {
        Optional<Movie> movie = movieService.findMovieById(movieId);
        if(!movie.isPresent()){
            throw new MovieNotFoundException("Movie not found with id:"+movieId);
        }
        return new ResponseEntity<>(reviewService.saveReview(movieId,reviewRequest), HttpStatus.CREATED);
    }
}
