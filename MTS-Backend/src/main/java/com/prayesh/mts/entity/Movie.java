package com.prayesh.mts.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Movie",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"movie_name"})}
    )    
public class Movie {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "movie_sequence"
    )
    @SequenceGenerator(
        name = "movie_sequence",
        sequenceName = "movie_sequence",
        initialValue = 55555,
        allocationSize = 1
    )
    @NotNull
    private long movieId;
    @Column(name = "movie_name")
    @NotBlank(message = "Enter movie name")
    private String movieName;
    @Column(name = "movie_cast")
    private String movieCast;
    @Column(name = "movie_rating")
    private double movieRating;
    @Column(name = "movie_genre")
    @NotEmpty(message = "Genre cannot be empty")
    private String movieGenre;
    @Column(name = "movie_language")
    @NotEmpty(message = "Language cannot be empty")
    private String movieLanguage;
    @Column(name = "movie_description")
    private String movieDescription;
    @Column(name = "movie_releaseDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Release Date cannot be null")
    private Date movieReleaseDate;
    @Column(name = "movie_duration")
    @NotNull(message = "Enter movie duration")
    private Integer movieDurationMin;
    @Column(name = "movie_endDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "End Date cannot be null")
    @Future(message = "End date cannot be from the past")
    private Date movieEndDate;

    // private Date startDate;   AddMovie API -> Sets the current date to start date
    // private Date endDate;     DeleteMovie API -> Sets the current date to end date 

}
