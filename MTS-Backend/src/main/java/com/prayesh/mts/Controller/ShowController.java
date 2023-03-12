package com.prayesh.mts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prayesh.mts.Service.ShowService;
import com.prayesh.mts.entity.Show;

@RestController
@RequestMapping("/shows")
public class ShowController {
    
    @Autowired
    private ShowService showService;

    @GetMapping("/getAllShows/{id}")
    public List<Show> getAllShows(@PathVariable("id") Long id){
        // What about reviews?
        return showService.getShows(id);
    }
}
