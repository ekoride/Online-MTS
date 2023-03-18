package com.prayesh.mts.Service;

import com.prayesh.mts.Repository.ReviewRepository;
import com.prayesh.mts.RequestHandlers.ReviewRequest;
import com.prayesh.mts.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImplementation implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(long movieId, ReviewRequest reviewRequest) {
        return reviewRepository.saveReview(movieId, reviewRequest.getUserReview(), reviewRequest.getUserRating());
    }
}
