package com.prayesh.mts.Response;

import java.util.List;

import com.prayesh.mts.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private long movieId;
    private String movie_name;
    private String movie_cast;
    private String movie_genre;
    private String movie_description;
    private String movie_language;
    private String movie_rating;
    private String movie_duration;
    private List<Review> reviews;
}
