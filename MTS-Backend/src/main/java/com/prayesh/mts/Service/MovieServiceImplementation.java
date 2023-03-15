package com.prayesh.mts.Service;

import java.util.Date;
import java.util.List;

import com.prayesh.mts.Advice.DBException;
import com.prayesh.mts.Advice.InvalidArgumentException;
import com.prayesh.mts.Advice.SystemException;
import org.hibernate.HibernateException;
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

    @Override
    public Movie movieByName(String movieName) {
        return movieRepository.findMovieByName(movieName);
    }













    @Override
    public List<Movie> getAllMovies() {
        try{
            Date currentDate = new Date();
            return movieRepository.findAllThatAreShowingNow(currentDate);
        }catch(HibernateException ex){
            throw new DBException(ex.getMessage());
        }catch(Exception ex){
            throw new SystemException(ex.getMessage());
        }

    }

    @Override
    public Movie saveMovie(Movie movie) {
        try{
            Date release = movie.getMovieReleaseDate();
            Date end = movie.getMovieEndDate();
            //Date currentDate = new Date();
            if(release.compareTo(end)>0){
                throw new InvalidArgumentException("Release date cannot be after end date");
            }
            return movieRepository.save(movie);
        }catch(HibernateException ex){
            throw new DBException(ex.getMessage());
        }catch (InvalidArgumentException ex){
            throw new InvalidArgumentException(ex.getMessage());
        }
        catch(Exception ex){
            throw new SystemException(ex.getMessage());
        }

    }
}
