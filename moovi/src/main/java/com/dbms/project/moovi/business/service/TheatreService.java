package com.dbms.project.moovi.business.service;

import com.dbms.project.moovi.data.entity.Theatre;
import com.dbms.project.moovi.data.entity.TheatreManager;
import com.dbms.project.moovi.data.repository.TheatreManagerRepository;
import com.dbms.project.moovi.data.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TheatreManagerRepository theatreManagerRepository;

    @PostMapping("/api/theatre")
    public Theatre createTheatre(@RequestBody Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @PostMapping("api/manage/theatre/{theatreId}/manager/{username}")
    public void theatreManagedBy(
            @PathVariable("username") String username,
            @PathVariable("theatreId") long theatreId){
        Theatre theatre = theatreRepository.findTheatreById(theatreId);
        TheatreManager theatreManager = theatreManagerRepository.findManagerByUsername(username);
        theatreManager.managedTheatres(theatre);
        theatreRepository.save(theatre);
    }
}
