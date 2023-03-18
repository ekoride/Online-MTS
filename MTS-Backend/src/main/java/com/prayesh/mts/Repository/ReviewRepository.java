package com.prayesh.mts.Repository;

import com.prayesh.mts.RequestHandlers.ReviewRequest;
import com.prayesh.mts.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


    @Query(value = "INSERT INTO REVIEW (movieId, userMovieReview, movieStatus) VALUES (?1,?2, ?3)",
    nativeQuery = true)
    public Review saveReview(long movieId, String userReview, int userRating);
}
