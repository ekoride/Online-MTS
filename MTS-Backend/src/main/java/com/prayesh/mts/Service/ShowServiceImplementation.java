package com.prayesh.mts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prayesh.mts.Repository.ShowRepository;
import com.prayesh.mts.entity.Show;

@Service
public class ShowServiceImplementation implements ShowService{

    @Autowired
    private ShowRepository showRepository;
    @Override
    public List<Show> getShows(Long id) {
        
        return showRepository.findAllShows(id);
    }
    
}
