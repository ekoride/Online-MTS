package com.prayesh.mts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.prayesh.mts.enums.MovieReview;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Review")
public class Review {

    @Id
    @SequenceGenerator(
        name = "review_sequence",
        sequenceName = "review_sequence",
        initialValue = 100,
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "review_sequence"
    )
    private long reviewId;

    //@Column(name = "review_movie", nullable = false)
    @ManyToOne
    @JoinColumn(
        name = "review_movie",
        referencedColumnName = "movieId"
    )
    private Movie movieId;
    //@Column(name = "review_user", nullable = false)
    @OneToOne
    @JoinColumn(
        name = "review_userId",
        referencedColumnName = "userId"
    )
    private user customerId;
    @Column(name = "user_review", nullable = false)
    private String userMovieReview;
    @Column(name = "movie_status")
    private MovieReview movieStatus;

}
