package com.prayesh.mts.RequestHandlers;

public class ReviewRequest {
    private String userReview;

    private int userRating;

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public ReviewRequest(String userReview, int userRating) {
        this.userReview = userReview;
        this.userRating = userRating;
    }

    public ReviewRequest() {
    }
}
