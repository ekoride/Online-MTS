package com.prayesh.mts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prayesh.mts.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{

    @Query(value = "SELECT s FROM MOVIE m INNER JOIN SHOW s Where m.movie_id = s.show_movieId",
        nativeQuery = true
    )
    public List<Show> findAllShows(Long id);
    
}
