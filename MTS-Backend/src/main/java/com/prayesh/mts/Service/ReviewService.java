package com.prayesh.mts.Service;

import com.prayesh.mts.RequestHandlers.ReviewRequest;
import com.prayesh.mts.entity.Review;
import org.springframework.stereotype.Service;

public interface ReviewService {
    public Review saveReview(long movieId, ReviewRequest reviewRequest);
}
