package com.prayesh.mts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prayesh.mts.Response.MovieResponse;
import com.prayesh.mts.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    
    
    @Query(value = "SELECT * from MOVIE m where m.movie_isAvailable = true and m.movie_name = ?1",
        nativeQuery = true
    )
    public Movie findMovieByName(String movieName);

    @Query(value = "SELECT * from movie m where m.movie_cast LIKE '%?1%'",
        nativeQuery = true
    )
    public List<Movie> getMovieByCast(String castName);
    
    @Query(value = "SELECT * FROM MOVIE m where m.movie_language = ?1 and m.movie_isAvailable = true",
        nativeQuery = true
    )
    public List<Movie> getMovieByLanguage(String language);

    @Query(value = "SELECT * FROM MOVIE m where m.movie_isAvailable = true",
        nativeQuery = true
    )
    public List<Movie> findAllThatAreShowingNow();



    //Get a List or reviews.
    @Query(value = "SELECT m.movie_id, m.movie_name, m.movie_genre, m.movie_language, m.movie_description, m.movie_cast, m.movie_duration"+
            "FROM MOVIE m INNER JOIN REVIEW r WHERE m.movie_id = r.review_movie",
            nativeQuery = true
    )
    public MovieResponse fetchCompleteMovieDetails(String movieId);
}











