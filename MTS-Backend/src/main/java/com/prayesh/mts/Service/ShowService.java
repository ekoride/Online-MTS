package com.prayesh.mts.Service;

import java.util.List;

import com.prayesh.mts.entity.Show;

public interface ShowService {

    List<Show> getShows(Long id);
    
}
